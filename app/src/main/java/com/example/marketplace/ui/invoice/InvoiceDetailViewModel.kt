package com.example.marketplace.ui.invoice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketplace.database.Invoice
import com.example.marketplace.database.InvoiceItem
import com.example.marketplace.database.MarketPlaceDatabaseDao

/* 
 *   created by mohdwaseem
 *   created on 26/1/21  
 *   Time: 2:15 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
class InvoiceDetailViewModel(
    invoiceId: Long = 0L,
    dataSource: MarketPlaceDatabaseDao
) : ViewModel() {

    val database = dataSource

    private val invoice: LiveData<Invoice>

    fun getInvoice() = invoice

    init {
        invoice = database.getInvoice(invoiceId)
    }

    /*whether to navigate to invoice list*/
    private var _navigateToInvoiceList = MutableLiveData<Boolean>()
    val navigateToInvoiceList: LiveData<Boolean>
        get() = _navigateToInvoiceList


    fun doneNavigating() {
        _navigateToInvoiceList.value = null
    }

    private suspend fun insert(invoiceItem: InvoiceItem) {
        database.insertInvoiceItem(invoiceItem)
    }

    fun onClose() {
        _navigateToInvoiceList.value = true
    }
}