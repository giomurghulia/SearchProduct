package com.example.searchproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.searchproduct.databinding.FragmentItemDetailBinding

class DetailItemFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item: Item? = arguments?.getParcelable(ITEM) ?: return

        binding.itemImage.setImageResource(item?.image!!)
        binding.itemTitleText.text = item.title
        binding.itemDescriptionText.text = item.description
    }


    companion object {
        const val ITEM = "item"

        fun newInstance(item: Item): DetailItemFragment {
            val fragment = DetailItemFragment()
            fragment.arguments = bundleOf(ITEM to item)

            return fragment
        }
    }
}
