package unideb.hu.fakebookc7zvm2.ui.posts

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import unideb.hu.fakebookc7zvm2.R
import unideb.hu.fakebookc7zvm2.databinding.PostsFragmentBinding


class Posts : Fragment() {

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application

        val binding = PostsFragmentBinding.inflate(inflater)

        val user = PostsArgs.fromBundle(arguments!!).selectedUser

        binding.setLifecycleOwner(this)

        val viewModelFactory = PostsViewModelFactory(user, application)
        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(PostsViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }

}
