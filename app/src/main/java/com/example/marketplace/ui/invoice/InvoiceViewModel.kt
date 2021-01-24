package com.example.marketplace.ui.invoice
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.database.Invoice
import com.example.marketplace.database.MarketPlaceDatabaseDao
import com.example.marketplace.network.Api
import kotlinx.coroutines.launch

class InvoiceViewModel(
    dataSource: MarketPlaceDatabaseDao,
    application: Application
) : ViewModel() {

    private val database = dataSource
    val invoices = database.getAllInvoice()

    private val _invoiceList = MutableLiveData<List<Invoice>>()
    val invoiceList: LiveData<List<Invoice>>
        get() = _invoiceList

    init {
        getInvoiceData()
    }

    private suspend fun insert(invoice: Invoice) {
        database.insertInvoice(invoice)
    }

    private suspend fun update(invoice: Invoice) {
        database.updateInvoice(invoice)
    }

    private suspend fun clear() {
        database.clearInvoice()
    }

    private fun getInvoiceData() {
        viewModelScope.launch {
            try {
                val apiResponse = Api.retrofitService.getInvoiceList()
                if (apiResponse.errorCode == 1 && apiResponse.data.isNotEmpty()) {
                    apiResponse.data.forEach {
                        insert(
                            Invoice(
                                id = it.id,
                                buyerName = it.buyerName,
                                totalAmount = it.total,
                                paidAmount = it.paidAmount,
                                createdAt = it.createdAt,
                                itemCount = it.itemCount
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("sample", "api failed")
                clear()
            }
        }
    }
}