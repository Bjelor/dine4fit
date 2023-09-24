package com.bjelor.dine4fit.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bjelor.dine4fit.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    private val searchResultAdapter by lazy { SearchResultsAdapter(::onItemClick) }
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.onSearchSubmit(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // TODO
                return false
            }
        })

        binding.searchResultList.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false,
            )
            adapter = searchResultAdapter
        }

        lifecycle.coroutineScope.launch {
            viewModel.searchResult.collect { searchResults ->
                searchResultAdapter.submitList(searchResults ?: emptyList())
            }
        }
    }

    private fun onItemClick(id: String) {
        val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(id)
        findNavController().navigate(action)
    }
}