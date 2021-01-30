package com.example.marketplace.ui.invoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.database.InvoiceItem
import com.example.marketplace.databinding.InvoiceSubItemBinding

/* 
 *   created by mohdwaseem
 *   created on 30/1/21  
 *   Time: 12:20 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
class InvoiceItemAdapter :
    ListAdapter<InvoiceItem, InvoiceItemAdapter.ViewHolder>(InvoiceItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: InvoiceSubItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InvoiceItem) {
            binding.invoiceItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = InvoiceSubItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class InvoiceItemDiffCallback : DiffUtil.ItemCallback<InvoiceItem>() {
    override fun areItemsTheSame(oldItem: InvoiceItem, newItem: InvoiceItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: InvoiceItem, newItem: InvoiceItem): Boolean {
        return oldItem == newItem
    }
}
