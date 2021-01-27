package com.example.marketplace.ui.invoice
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marketplace.database.Invoice
import com.example.marketplace.util.convertEpochToDate
import java.text.NumberFormat
import java.util.*


@BindingAdapter("paidAmount")
fun TextView.setPaidAmount(item: Invoice) {
    item.let {
        text = NumberFormat.getCurrencyInstance(Locale("en", "IN")).format(item.paidAmount)
    }
}


@BindingAdapter("totalAmount")
fun TextView.setTotalAmount(item: Invoice) {
    item.let {
        text = NumberFormat.getCurrencyInstance(Locale("en", "IN")).format(item.totalAmount)
    }
}

@BindingAdapter("dateFormat")
fun TextView.setDateFormat(item: Invoice) {
    item.let {
        text = convertEpochToDate(item.createdAt)
    }
}

@BindingAdapter("buyerName")
fun TextView.setBuyerName(item: Invoice) {
    item.let {
        text = item.buyerName
    }
}
