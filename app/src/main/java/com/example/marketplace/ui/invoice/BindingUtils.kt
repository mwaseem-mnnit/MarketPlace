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
import java.text.NumberFormat
import java.util.*


@BindingAdapter("paidAmount")
fun TextView.paidAmount(item: Invoice) {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    text = format.format(item.paidAmount)
}


@BindingAdapter("totalAmount")
fun TextView.totalAmount(item: Invoice) {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    text = format.format(item.totalAmount)
}
