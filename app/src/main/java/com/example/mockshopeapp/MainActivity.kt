package com.example.mockshopeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mockshopeapp.databinding.ActivityMainBinding
import com.example.mockshopeapp.ui.productsList.ProductListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addProductsListFragment(fragment = ProductListFragment())

    }

    private fun addProductsListFragment(fragment: ProductListFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_Container,fragment)
        transaction.commit()

    }
}