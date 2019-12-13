package unideb.hu.fakebookc7zvm2

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import unideb.hu.fakebookc7zvm2.adapters.PostAdapter
import unideb.hu.fakebookc7zvm2.adapters.UserAdapter
import unideb.hu.fakebookc7zvm2.network.Post
import unideb.hu.fakebookc7zvm2.network.User

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(data)
}

@BindingAdapter("postData")
fun bindPostRecyclerView(recyclerView: RecyclerView, data: List<Post>?) {
    val adapter = recyclerView.adapter as PostAdapter
    adapter.submitList(data)
}