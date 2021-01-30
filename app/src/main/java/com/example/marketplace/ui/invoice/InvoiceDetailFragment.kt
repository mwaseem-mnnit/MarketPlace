package com.example.marketplace.ui.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketplace.R
import com.example.marketplace.database.MarketPlaceDatabase
import com.example.marketplace.databinding.FragmentInvoiceDetailBinding

class InvoiceDetailFragment : Fragment() {
    private lateinit var invoiceDetailViewModel: InvoiceDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bindings: FragmentInvoiceDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_invoice_detail, container, false)
        val application = requireNotNull(this.activity).application
        val arguments = InvoiceDetailFragmentArgs.fromBundle(arguments!!)

        val dataSource = MarketPlaceDatabase.getInstance(application).marketPlaceDatabaseDao
        val viewModelFactory = InvoiceDetailViewModelFactory(arguments.invoiceId, dataSource)

        invoiceDetailViewModel =
            ViewModelProvider(this, viewModelFactory).get(InvoiceDetailViewModel::class.java)
        bindings.invoiceDetailViewModel = invoiceDetailViewModel
        bindings.lifecycleOwner = this

        val invoiceItemAdapter = InvoiceItemAdapter()
        bindings.invoiceItemList.adapter = invoiceItemAdapter

        invoiceDetailViewModel.invoiceItemList.observe(viewLifecycleOwner, {
            it?.let {
                invoiceItemAdapter.submitList(it)
            }
        })

        val manager = LinearLayoutManager(activity)
        bindings.invoiceItemList.layoutManager = manager
        return bindings.root
    }
}