package com.example.searchproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.searchproduct.databinding.FragmentAllItemBinding
import java.util.*

class AllProductFragment : Fragment() {
    private lateinit var binding: FragmentAllItemBinding
    private val myAdapter = MyAdapter()

    private var allItemList: List<Item> = ALL_ITEMS

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentAllItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainRecycleView.layoutManager =
            GridLayoutManager(context, 3)
        binding.mainRecycleView.adapter = myAdapter
        updateAdapter(allItemList)

        binding.swipeRefresh.setOnRefreshListener {
            refresh()
        }

        binding.searchEdittext.doAfterTextChanged { text ->
            val keyword = if (text.isNullOrBlank()) null else text.toString()
            val filteredList = allItemList.filter { product ->
                keyword?.let { product.title.lowercase().contains(it.lowercase()) } ?: true
            }

            updateAdapter(filteredList)
        }

        myAdapter.setCallBack(object : MyAdapter.CallBack {
            override fun onItemClick(item: Item) {
                val mainActivity = activity as? MainActivity
                mainActivity?.startItemDetailFragment(item)
            }
        })
    }

    private fun updateAdapter(items: List<Item>) {
        myAdapter.submitList(items)
    }

    private fun refresh() {
        binding.swipeRefresh.isRefreshing = false
        binding.searchEdittext.text = null
    }

    companion object {
        fun newInstance(): AllProductFragment {
            return AllProductFragment()
        }
    }
}

val ALL_ITEMS = listOf(
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BOLTO ",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOGO",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "JEKA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BLACK BAGIRA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "LUCI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "NENSI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ), Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BOLTO ",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOGO",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "JEKA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BLACK BAGIRA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "LUCI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "NENSI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ), Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BOLTO ",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOGO",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "JEKA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BLACK BAGIRA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "LUCI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "NENSI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ), Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BOLTO ",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOGO",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "JEKA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BLACK BAGIRA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "LUCI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "NENSI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ), Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BOLTO ",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOGO",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "TOBI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "JEKA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "BLACK BAGIRA",
        R.drawable.ic_simba,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "LUCI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    ),
    Item(
        generateId(),
        "NENSI",
        R.drawable.ic_tobi,
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
    )
)

private fun generateId(): String {
    return UUID.randomUUID().toString()
}