package com.example.marketplace.ui.invoice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.database.Invoice
import com.example.marketplace.database.InvoiceItem
import com.example.marketplace.database.MarketPlaceDatabaseDao
import com.example.marketplace.network.Api
import kotlinx.coroutines.launch

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


    var invoiceItemList: LiveData<List<InvoiceItem>> = MutableLiveData()

    init {
        invoice = database.getInvoice(invoiceId)
        getInvoiceDetail(invoiceId)
    }

    private suspend fun insert(invoiceItem: InvoiceItem) {
        database.insertInvoiceItem(invoiceItem)
    }

    private fun getInvoiceDetail(invoiceId: Long) {
        viewModelScope.launch {
            val apiResponse = Api.retrofitService.getInvoiceDetail(invoiceId)
            if (apiResponse.errorCode == 1) {
                apiResponse.data?.items?.forEach {
                    insert(
                        InvoiceItem(
                            id = it.id,
                            invoiceId = invoiceId,
                            productName = it.productName,
                            productImageUrl = it.productImageUrl.toString(),
                            quantity = it.quantity,
                            cost = it.cost,
                            sellingPrice = it.sellingPrice,
                            discount = it.discount
                        )
                    )
                }
                invoiceItemList = database.getInvoiceItemAll()
            }
        }

    }
}