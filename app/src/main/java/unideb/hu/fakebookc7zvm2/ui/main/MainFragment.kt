package unideb.hu.fakebookc7zvm2.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import unideb.hu.fakebookc7zvm2.R
import unideb.hu.fakebookc7zvm2.adapters.UserAdapter
import unideb.hu.fakebookc7zvm2.databinding.MainFragmentBinding
import unideb.hu.fakebookc7zvm2.databinding.UserItemBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = MainFragmentBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        binding.userList.adapter = UserAdapter( UserAdapter.OnClickListener {

            viewModel.displayPosts(it)
        } )

        viewModel.navigateToSelectedUser.observe(this, Observer {
            if(null != it) {
                this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToPosts(it))


                viewModel.displaydisplayPostsComplete();
            }
        })

        return binding.root
    }

}
