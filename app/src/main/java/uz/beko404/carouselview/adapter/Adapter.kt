package uz.beko404.carouselview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.animation.AnimationUtils.lerp
import uz.beko404.carouselview.databinding.ItemBinding
import uz.beko404.carouselview.model.Item

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val dif = AsyncListDiffer(this, ITEM_DIFF)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dif.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            itemImage.setImageResource(dif.currentList[position].image)
            itemTitle.text = dif.currentList[position].title
            carouselItemContainer.setOnMaskChangedListener { maskRect ->
                itemTitle.translationX = maskRect.left
//                itemTitle.alpha = lerp(1f,1f,0.3f,1f, maskRect.left)
            }
        }
    }

    fun submitList(items: List<Item>) {
        dif.submitList(items)
    }

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.image == newItem.image
        }
    }
}