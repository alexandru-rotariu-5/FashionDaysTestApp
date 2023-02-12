package com.example.fashiondaystestapp.ui.product_list

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.fashiondaystestapp.R
import com.example.fashiondaystestapp.ui.models.ProductItem


class ProductListAdapter :
    ListAdapter<ProductItem, ProductListAdapter.ProductViewHolder>(ProductDiffCallBack()) {

    class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val productContainer: ConstraintLayout
        private val productBrand: TextView
        private val productName: TextView

        init {
            productContainer = itemView.findViewById(R.id.productContainer)
            productBrand = itemView.findViewById(R.id.tvProductBrand)
            productName = itemView.findViewById(R.id.tvProductName)
        }

        fun onBind(product: ProductItem) {
            productBrand.text = product.brand
            productName.text = product.name
            Glide.with(productContainer.context)
                .load(product.imageUrl)
                .into(object : CustomTarget<Drawable?>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable?>?
                    ) {
                        productContainer.background = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
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
