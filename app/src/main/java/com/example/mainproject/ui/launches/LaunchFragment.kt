package com.example.mainproject.ui.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainproject.data.network.models.SpaceXLaunch
import com.example.mainproject.databinding.FragmentLaunchBinding
import com.example.mainproject.extensions.hide
import com.example.mainproject.extensions.show
import com.example.mainproject.util.Util.showSnackbar

class LaunchFragment : Fragment(), ItemListener {

    private lateinit var binding: FragmentLaunchBinding

    private val viewModel: LaunchViewModel by viewModels()

    private lateinit var launchAdapter: LaunchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchBinding.inflate(layoutInflater)

        initAdapter()

        observer()

        viewModel.getLaunches()

        return binding.root
    }

    private fun observer(){
        viewModel.launches.observe(viewLifecycleOwner, {
            launchAdapter.updateData(it)

            binding.animationView.hide()
            binding.rvLaunches.show()
        })
    }

    private fun initAdapter(){
        launchAdapter = LaunchAdapter(this)

        binding.rvLaunches.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = launchAdapter
        }
    }

    override fun onClickWikipedia(launch: SpaceXLaunch) {
        val url = launch.links.wikipedia

        if (url != null) {
            findNavController().navigate(LaunchFragmentDirections.actionLaunchFragmentToArticleFragment(url))
        } else {
            showSnackbar(binding.root, "Url Doesn't Exist")
        }
    }

    override fun onClickArticle(launch: SpaceXLaunch) {
        val url = launch.links.article_link

        if (url != null) {
            findNavController().navigate(LaunchFragmentDirections.actionLaunchFragmentToArticleFragment(url))
        } else {
            showSnackbar(binding.root, "Url Doesn't Exist")
        }
    }

}