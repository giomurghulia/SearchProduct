package com.example.searchproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.searchproduct.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        handleWindowInset()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AllProductFragment.newInstance())
            .commit()
    }

    private fun handleWindowInset() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            binding.root.updatePadding(bottom = insets.bottom)

            windowInsets

        }
    }

    fun startItemDetailFragment(item: Item) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DetailItemFragment.newInstance(item))
            .addToBackStack("ItemDetailFragment")
            .commit()
    }
}