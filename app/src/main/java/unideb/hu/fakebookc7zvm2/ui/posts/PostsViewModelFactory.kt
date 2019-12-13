package unideb.hu.fakebookc7zvm2.ui.posts

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import unideb.hu.fakebookc7zvm2.network.User

class PostsViewModelFactory(
    private val user: User,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
            return PostsViewModel(user, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}