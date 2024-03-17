package com.omar.storeApp.ui.productsList.adapter

import androidx.recyclerview.widget.DiffUtil
import com.omar.domain.model.Product

internal class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem == newItem
    }
}
