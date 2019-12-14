package unideb.hu.fakebookc7zvm2.ui.posts

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import unideb.hu.fakebookc7zvm2.R
import unideb.hu.fakebookc7zvm2.adapters.PostAdapter
import unideb.hu.fakebookc7zvm2.databinding.PostsFragmentBinding
import unideb.hu.fakebookc7zvm2.ui.main.MainViewModel
import java.util.logging.Logger


class Posts : Fragment() {

    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this).get(PostsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = PostsFragmentBinding.inflate(inflater)


        binding.setLifecycleOwner(this)

        val user = PostsArgs.fromBundle(arguments!!).selectedUser

        viewModel.setUser(user)

        binding.viewModel = viewModel

        binding.postList.adapter = PostAdapter( PostAdapter.OnClickListener {

        } )

        return binding.root
    }

}
