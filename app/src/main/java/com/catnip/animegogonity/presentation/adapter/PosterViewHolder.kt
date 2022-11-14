package com.catnip.animegogonity.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.animegogonity.data.network.api.model.Anime
import com.catnip.animegogonity.databinding.ItemAnimePosterBinding
import com.catnip.animegogonity.databinding.ItemAnimePosterGridBinding

interface PosterViewHolder {
    fun bindView(item: Anime?)
}

class PosterViewHolderImpl(
    private val binding: ItemAnimePosterBinding,
    val itemClick: (Anime) -> Unit
) : RecyclerView.ViewHolder(binding.root), PosterViewHolder {

    override fun bindView(item: Anime?) {
        item?.let { movie ->
            binding.ivPoster.load(movie.animeImg)
            itemView.setOnClickListener { itemClick(movie) }
        }
    }
}

class GridPosterViewHolderImpl(
    private val binding: ItemAnimePosterGridBinding,
    val itemClick: (Anime) -> Unit
) : RecyclerView.ViewHolder(binding.root), PosterViewHolder {

    override fun bindView(item: Anime?) {
        item?.let { movie ->
            binding.ivPoster.load(movie.animeImg)
            itemView.setOnClickListener { itemClick(movie) }
        }
    }
}
