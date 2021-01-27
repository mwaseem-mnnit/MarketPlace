package com.example.marketplace.ui.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.database.MarketPlaceDatabase
import com.example.marketplace.databinding.FragmentInvoiceDetailBinding

class InvoiceDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindings: FragmentInvoiceDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invoice_detail, container, false)
        val application = requireNotNull(this.activity).application
        val arguments = InvoiceDetailFragmentArgs.fromBundle(arguments!!)
//        val arguments = arguments?.let { InvoiceDetailFragmentArgs.fromBundle(it) }

        Toast.makeText(context, "${arguments?.invoiceId}", Toast.LENGTH_LONG).show()

        val dataSource = MarketPlaceDatabase.getInstance(application).marketPlaceDatabaseDao
        val viewModelFactory = InvoiceDetailViewModelFactory(arguments.invoiceId, dataSource)
        val invoiceDetailViewModel = ViewModelProvider(this, viewModelFactory).get(InvoiceDetailViewModel::class.java)

        bindings.invoiceDetailViewModel = invoiceDetailViewModel
        invoiceDetailViewModel.navigateToInvoiceList.observe(viewLifecycleOwner, {
            if(it == true) {
                this.findNavController().navigate(InvoiceDetailFragmentDirections.actionNavInvoiceDetailToNavInvoice())
                invoiceDetailViewModel.doneNavigating()
            }
        })

        return inflater.inflate(R.layout.fragment_invoice_detail, container, false)
    }
}