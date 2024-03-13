package com.example.mockshopeapp.ui.productsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.CategoryResponse
import com.example.mockshopeapp.databinding.FragmentProductListBinding
import com.example.mockshopeapp.ui.Adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductAdapter.OnItemClickListener {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val productAdapter = ProductAdapter(this)
    private lateinit var viewModel: ProductsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setupLiveDataObservers()
        setupRecyclerView()
        fetchData()
    }

    private fun setupRecyclerView() {
        binding.productRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }


    private fun fetchData() = viewModel.getProduct()

    private fun setupLiveDataObservers() {

        lifecycleScope.launch {
            viewModel.categories.collect {
                productAdapter.submitList(it)
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[ProductsListViewModel::class.java]
    }

    override fun onItemClickListener(position: Int) {
        Toast.makeText(requireContext(), "Click", Toast.LENGTH_SHORT).show()
    }
}