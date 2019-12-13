package unideb.hu.fakebookc7zvm2.ui.posts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import unideb.hu.fakebookc7zvm2.network.FakebookApi
import unideb.hu.fakebookc7zvm2.network.Post
import unideb.hu.fakebookc7zvm2.network.User

class PostsViewModel(user: User, app: Application) : AndroidViewModel(app) {

    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>>
        get() = _posts

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPosts(user)
    }

    private fun getPosts(user: User) {
        coroutineScope.launch {
            var getPostsDeffered = FakebookApi.retrofitService.getPosts(user.id)
            try {
                val listResult = getPostsDeffered.await()
                _posts.value = listResult
            } catch (e: Exception) {
                _posts.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
