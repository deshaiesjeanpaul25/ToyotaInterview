package com.deshaies.toyotainterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshaies.toyotainterview.adapters.ProductAdapter
import com.deshaies.toyotainterview.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter

        productViewModel.products.observe(this) { products ->
            progressBar.visibility = View.GONE
            productAdapter.updateData(products)
        }

        productViewModel.error.observe(this) { error ->
            progressBar.visibility = View.GONE
        }

        progressBar.visibility = View.VISIBLE
        productViewModel.fetchProducts()
    }
}