package unideb.hu.fakebookc7zvm2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import unideb.hu.fakebookc7zvm2.network.FakebookApi
import unideb.hu.fakebookc7zvm2.network.User

class MainViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()

    val users: LiveData<List<User>>
        get() = _users

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getUsers()
    }


    private val _navigateToSelectedUser = MutableLiveData<User>()
    val navigateToSelectedUser: LiveData<User>
        get() = _navigateToSelectedUser

    private fun getUsers() {
        coroutineScope.launch {
            var getUsersDeffered = FakebookApi.retrofitService.getUsers()
            try {
                val listResult = getUsersDeffered.await()
                _users.value = listResult
            } catch (e: Exception) {
                _users.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPosts(user: User) {
        _navigateToSelectedUser.value = user
    }

    fun displaydisplayPostsComplete() {
        _navigateToSelectedUser.value = null
    }

}
