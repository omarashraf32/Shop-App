package com.omar.storeApp.ui.productsList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.omar.domain.model.Product
import com.omar.storeApp.databinding.ItemProductBinding

class ProductAdapter(private val onItemClicked: OnItemClickListener) :
    ListAdapter<Product, ProductAdapter.ViewHolder>(ProductDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val itemBinding: ItemProductBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: Product) {
            category.apply {
                itemBinding.apply {
                    tvTitle.text = title
                    tvPrice.text = price.toString()
                    tvDesc.text  = description
                    imgProduct.load(image)
                }
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClicked.onItemClickListener(getItem(adapterPosition))
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClickListener(product: Product)
    }
}