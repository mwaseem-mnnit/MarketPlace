package com.example.marketplace.ui.invoice
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.database.Invoice
import com.example.marketplace.databinding.InvoiceListItemBinding

class InvoiceAdapter : ListAdapter<Invoice, InvoiceAdapter.ViewHolder>(InvoiceDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: InvoiceListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Invoice) {
            binding.invoice = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = InvoiceListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class InvoiceDiffCallback : DiffUtil.ItemCallback<Invoice>() {
    override fun areItemsTheSame(oldItem: Invoice, newItem: Invoice): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Invoice, newItem: Invoice): Boolean {
        return oldItem == newItem
    }

}