package com.example.fashiondaystestapp.ui.product_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fashiondaystestapp.databinding.FragmentProductListBinding
import com.example.fashiondaystestapp.ui.models.ProductItem

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductListViewModel by viewModels()

    private lateinit var productListAdapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productsObserver = Observer<List<ProductItem>> { newList ->
            productListAdapter.submitList(newList)
        }

        viewModel.products.observe(requireActivity(), productsObserver)
    }

    private fun setupRecyclerView () {
        val productsRecyclerView = binding.rvProducts

        productListAdapter = ProductListAdapter()
        productsRecyclerView.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2)
            adapter = productListAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}