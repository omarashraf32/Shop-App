package com.example.mockshopeapp.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CategoryResponseItem
import com.example.mockshopeapp.databinding.CategoryItemBinding
import com.example.mockshopeapp.ui.productsList.ProductListFragment

class ProductAdapter(productListFragment: ProductListFragment) : ListAdapter<CategoryResponseItem, ProductAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: CategoryResponseItem) {
            itemBinding.categoryTitleTv.text = category.title
            itemBinding.categoryPriceTv.text = category.price.toString()
            Glide.with(itemBinding.root.context).load(category.image).into(itemBinding.categoryIv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CategoryResponseItem,
            newItem: CategoryResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CategoryResponseItem,
            newItem: CategoryResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}