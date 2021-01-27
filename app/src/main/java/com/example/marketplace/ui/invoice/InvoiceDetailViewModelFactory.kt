package com.example.marketplace.ui.invoice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marketplace.database.MarketPlaceDatabaseDao

/* 
 *   created by mohdwaseem
 *   created on 26/1/21  
 *   Time: 5:19 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
class InvoiceDetailViewModelFactory(
    private val invoiceId: Long,
    private val dataSource: MarketPlaceDatabaseDao
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(InvoiceDetailViewModel::class.java)) {
            return InvoiceDetailViewModel(invoiceId, dataSource) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}