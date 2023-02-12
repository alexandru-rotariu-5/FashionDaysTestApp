package com.example.fashiondaystestapp.ui.product_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.fashiondaystestapp.App
import com.example.fashiondaystestapp.databinding.FragmentProductListBinding
import com.example.fashiondaystestapp.ui.models.ProductItem
import javax.inject.Inject


class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var viewModel: ProductListViewModel

    private lateinit var productListAdapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupSwipeRefresh()
        (activity?.application as App).appComponent.inject(this)
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

    private fun setupSwipeRefresh() {
        binding.swipeContainer.setOnRefreshListener {
            viewModel.updateProducts(::stopSwipeRefresh)
        }
    }

    private fun stopSwipeRefresh() {
        binding.swipeContainer.isRefreshing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}