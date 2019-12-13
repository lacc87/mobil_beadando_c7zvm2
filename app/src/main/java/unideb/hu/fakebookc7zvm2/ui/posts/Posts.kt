package unideb.hu.fakebookc7zvm2.ui.posts

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import unideb.hu.fakebookc7zvm2.R
import unideb.hu.fakebookc7zvm2.adapters.UserAdapter
import unideb.hu.fakebookc7zvm2.databinding.MainFragmentBinding
import unideb.hu.fakebookc7zvm2.databinding.PostsFragmentBinding
import unideb.hu.fakebookc7zvm2.ui.main.MainFragmentDirections


class Posts : Fragment() {

    companion object {
        fun newInstance() = Posts()
    }

    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this).get(PostsViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = PostsFragmentBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        return binding.root
    }


}
