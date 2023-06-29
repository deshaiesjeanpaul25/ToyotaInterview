package com.deshaies.toyotainterview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deshaies.toyotainterview.R
import com.deshaies.toyotainterview.data.Product

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var products: List<Product> = emptyList()
    fun updateData(products: List<Product>){
        this.products = products
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(product: Product){
            itemView.findViewById<TextView>(R.id.title).text = product.title
            itemView.findViewById<TextView>(R.id.description).text = product.description

            val image : ImageView =itemView.findViewById<ImageView>(R.id.image)

            Glide.with(itemView)
                .load(product.images[0])
                .into(image)
        }
    }
}