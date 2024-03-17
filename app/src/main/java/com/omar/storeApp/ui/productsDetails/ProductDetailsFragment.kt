package com.omar.storeApp.ui.productsDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.omar.domain.model.Product
import com.omar.storeApp.R
import com.omar.storeApp.databinding.FragmentProductDetailsBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private val args: ProductDetailsFragmentArgs by navArgs()

    private val product: Product? by lazy {
        try {
            Gson().fromJson(args.productJson, Product::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (product == null) { // in case of product was null return
            Toast.makeText(context, R.string.something_went_wrong, Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
            return
        }
        setupViews()
    }

    private fun setupViews() {
        binding.apply {
            product?.apply {
                tvTitle.text = title
                tvDescription.text = description
                tvPrice.text = price?.toString()
                imgProduct.load(image)
            }
        }
    }

}