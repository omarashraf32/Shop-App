package com.omar.storeApp.ui.productsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.omar.domain.model.Product
import com.omar.storeApp.R
import com.omar.storeApp.databinding.FragmentProductListBinding
import com.omar.storeApp.ui.productsList.adapter.ProductAdapter
import com.omar.storeApp.ui.productsList.states.GetProductsError
import com.omar.storeApp.ui.productsList.states.GetProductsLoading
import com.omar.storeApp.ui.productsList.states.GetProductsSuccess
import com.omar.storeApp.ui.productsList.states.InitState
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductAdapter.OnItemClickListener {

    private lateinit var binding: FragmentProductListBinding
    private val productAdapter = ProductAdapter(this)
    private lateinit var viewModel: ProductsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setupRecyclerView()
        setupLiveDataObservers()
        fetchData()
    }

    private fun setupRecyclerView() {
        binding.productsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }


    private fun fetchData() = viewModel.getProducts()

    private fun setupLiveDataObservers() {
        lifecycleScope.launch {
            viewModel.categories.collect { state ->
                when (state) {
                    is GetProductsLoading -> showLoading()
                    is GetProductsSuccess -> onGetProductsSuccess(state.products)
                    is GetProductsError -> onGetProductsError()
                    is InitState -> onGetProductsInitState()
                }
            }
        }
    }

    private fun onGetProductsInitState() {}

    private fun onGetProductsError() {
        hideLoading()
        view?.let { view ->
            Snackbar.make(view, R.string.something_went_wrong, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry) { viewModel.getUpdatedProducts() }.show()
        }
    }

    private fun onGetProductsSuccess(products: List<Product>) {
        hideLoading()
        productAdapter.submitList(products)
    }

    private fun hideLoading() {}

    private fun showLoading() {}

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[ProductsListViewModel::class.java]
    }

    override fun onItemClickListener(product: Product) {
        findNavController().navigate(
            ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(
                Gson().toJson(
                    product
                )
            )
        )
    }
}