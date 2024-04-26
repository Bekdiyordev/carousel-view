package uz.beko404.carouselview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.beko404.carouselview.R
import uz.beko404.carouselview.adapter.Adapter
import uz.beko404.carouselview.databinding.ActivityMainBinding
import uz.beko404.carouselview.model.Item
import uz.beko404.sharedelementtransaction.utill.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { Adapter() }
    private val dataList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        setupUI()
    }

    private fun loadData() {
        dataList.clear()
        dataList.add(Item(R.drawable.img_1, "Title 1"))
        dataList.add(Item(R.drawable.img_2, "Title 2"))
        dataList.add(Item(R.drawable.img_3, "Title 3"))
        dataList.add(Item(R.drawable.img_4, "Title 4"))
        dataList.add(Item(R.drawable.img_5, "Title 5"))
        dataList.add(Item(R.drawable.img_6, "Title 6"))
        dataList.add(Item(R.drawable.img_7, "Title 7"))
        dataList.add(Item(R.drawable.img_8, "Title 8"))
        dataList.add(Item(R.drawable.img_9, "Title 9"))
        dataList.add(Item(R.drawable.img_10, "Title 10"))
        dataList.add(Item(R.drawable.img_11, "Title 11"))
        dataList.add(Item(R.drawable.img_12, "Title 12"))
        adapter.submitList(dataList)
    }

    private fun setupUI() = with(binding){
        carouselRecycler.adapter = adapter
    }
}