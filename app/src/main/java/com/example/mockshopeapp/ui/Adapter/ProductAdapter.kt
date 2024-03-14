package com.example.mockshopeapp.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CategoryResponseItem
import com.example.mockshopeapp.databinding.CategoryItemBinding

class ProductAdapter(private val onItemClicked: OnItemClickListener) :
    ListAdapter<CategoryResponseItem, ProductAdapter.ViewHolder>(CategoryDiffCallback()) {


    interface OnItemClickListener {
        fun onItemClickListener(category: CategoryResponseItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: CategoryResponseItem) {
            itemBinding.categoryTitleTv.text = category.title
            itemBinding.categoryPriceTv.text = category.price.toString()
            Glide.with(itemBinding.root.context).load(category.image).into(itemBinding.categoryIv)
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClickListener(adapterPosition)
            }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CategoryResponseItem,
            newItem: CategoryResponseItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryResponseItem,
            newItem: CategoryResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}