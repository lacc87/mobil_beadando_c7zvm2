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
import java.util.logging.Logger

class PostsViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>>
        get() = _posts

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPosts()
    }

    private fun getPosts() {
        coroutineScope.launch {
            var getPostsDeffered = FakebookApi.retrofitService.getPosts(user.value!!.id)
            try {
                val listResult = getPostsDeffered.await()
                _posts.value = listResult
            } catch (e: Exception) {
                _posts.value = ArrayList()
            }
        }
    }

    fun setUser(user: User) {
        _user.value = user
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
