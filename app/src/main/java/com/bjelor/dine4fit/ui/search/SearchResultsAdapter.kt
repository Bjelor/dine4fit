package com.bjelor.dine4fit.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bjelor.dine4fit.databinding.AdapterItemSearchResultBinding
import com.bjelor.dine4fit.domain.model.SearchResult

private val searchAdapterDiffCallback = object : DiffUtil.ItemCallback<SearchResult>() {
    override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
        return oldItem == newItem
    }
}

class SearchResultsAdapter(
    private val onItemClick: (String) -> Unit
) : ListAdapter<SearchResult, SearchResultsAdapter.ViewHolder>(
    searchAdapterDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(
            AdapterItemSearchResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClick(getItem(position).id)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: AdapterItemSearchResultBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(searchResult: SearchResult) {
            binding.searchResult = searchResult
            binding.thumbnmail.load(searchResult.thumbnailUrl)
        }
    }

}