package com.example.marketplace.ui.invoice
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketplace.R
import com.example.marketplace.database.MarketPlaceDatabase
import com.example.marketplace.databinding.FragmentInvoiceBinding

class InvoiceFragment : Fragment() {

    private lateinit var invoiceViewModel: InvoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentInvoiceBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_invoice, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = MarketPlaceDatabase.getInstance(application).marketPlaceDatabaseDao
        val viewModelFactory = InvoiceViewModelFactory(dataSource, application)

        invoiceViewModel =
            ViewModelProvider(this, viewModelFactory).get(InvoiceViewModel::class.java)
        binding.invoiceViewModel = invoiceViewModel
        binding.lifecycleOwner = this

        val invoiceAdapter = InvoiceAdapter(InvoiceListener { invoiceId ->
            invoiceViewModel.onInvoiceClicked(invoiceId)
            Toast.makeText(context, "$invoiceId", Toast.LENGTH_LONG).show()
        })
        binding.invoiceList.adapter = invoiceAdapter

        invoiceViewModel.invoices.observe(viewLifecycleOwner, {
            it?.let {
                invoiceAdapter.submitList(it)
            }
        })

        invoiceViewModel.navigateToInvoiceDetail.observe(this, Observer {
            invoiceId -> invoiceId?.let {
                this.findNavController().navigate(
                    InvoiceFragmentDirections.actionNavInvoiceToNavInvoiceDetail(invoiceId)
                )
                invoiceViewModel.onInvoiceDetailNavigated()
            }
        })

        val manager = LinearLayoutManager(activity)
        binding.invoiceList.layoutManager = manager
        return binding.root
    }
}