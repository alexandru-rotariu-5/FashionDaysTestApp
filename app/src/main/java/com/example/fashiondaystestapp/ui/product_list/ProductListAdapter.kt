package com.example.fashiondaystestapp.ui.product_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fashiondaystestapp.R
import com.example.fashiondaystestapp.ui.models.ProductItem

class ProductListAdapter :
    ListAdapter<ProductItem, ProductListAdapter.ProductViewHolder>(ProductDiffCallBack()) {

    class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val productBrand: TextView
        private val productName: TextView
        private val productImage: ImageView

        init {
            productBrand = itemView.findViewById(R.id.tvProductBrand)
            productName = itemView.findViewById(R.id.tvProductName)
            productImage = itemView.findViewById(R.id.ivProductImage)
        }

        fun onBind(product: ProductItem) {
            productBrand.text = product.brand
            productName.text = product.name
            Glide.with(productImage.context)
                .load(product.imageUrl)
                .into(productImage)
        }
    }

    private class ProductDiffCallBack : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_item, viewGroup, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) = viewHolder.onBind(getItem(position))
}
