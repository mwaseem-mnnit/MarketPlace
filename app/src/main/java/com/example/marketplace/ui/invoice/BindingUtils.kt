package com.example.marketplace.ui.invoice
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marketplace.database.InvoiceItem
import com.example.marketplace.util.convertEpochToDate
import java.text.NumberFormat
import java.util.*

@BindingAdapter("amount")
fun TextView.setAmount(amount: Double) {
    text = NumberFormat.getCurrencyInstance(Locale("en", "IN")).format(amount)
}

@BindingAdapter("total")
fun TextView.setTotal(item: InvoiceItem) {
    text = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        .format(item.quantity * item.sellingPrice)
}

@BindingAdapter("epochToDate")
fun TextView.setEpochToDate(epoch: Long) {
    text = convertEpochToDate(epoch)
}