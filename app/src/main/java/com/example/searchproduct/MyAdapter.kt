package com.example.searchproduct

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchproduct.databinding.LayoutItemBinding

class MyAdapter : ListAdapter<Item, MyAdapter.ProductViewHolder>(MyDiffUtil()) {
    private var callBack: CallBack? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setCallBack(callBack: CallBack) {
        this.callBack = callBack
    }

    inner class ProductViewHolder(
        private val binding: LayoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {

            binding.itemImage.setImageResource(item.image)

            binding.itemImage.setOnClickListener {
                callBack?.onItemClick(item)
            }
        }
    }

    interface CallBack {
        fun onItemClick(item: Item)
    }

}
