package unideb.hu.fakebookc7zvm2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import unideb.hu.fakebookc7zvm2.databinding.PostItemBinding
import unideb.hu.fakebookc7zvm2.databinding.UserItemBinding
import unideb.hu.fakebookc7zvm2.network.Post
import unideb.hu.fakebookc7zvm2.network.User

class PostAdapter (private val onClickListener: OnClickListener) :
    ListAdapter<Post,
            PostAdapter.PostViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(post)
        }
        holder.bind(post)
    }

    class OnClickListener(val clickListener: (post:Post) -> Unit) {
        fun onClick(post:Post) = clickListener(post)
    }

    class PostViewHolder(private var binding: PostItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }
    }

}