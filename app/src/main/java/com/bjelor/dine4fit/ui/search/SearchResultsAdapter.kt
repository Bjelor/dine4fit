package com.bjelor.dine4fit.ui.search

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bjelor.dine4fit.domain.SearchResult

private val searchAdapterDiffCallback = object : DiffUtil.ItemCallback<SearchResult>() {
    override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }
}

class SearchResultsAdapter : ListAdapter<SearchResult, SearchResultsAdapter.ViewHolder>(
    searchAdapterDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO
    }


}