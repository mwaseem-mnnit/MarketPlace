package com.example.marketplace.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice")
data class Invoice (
    @PrimaryKey(autoGenerate = true)
    var invoiceId: Long = 0L,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "total_amount")
    var totalAmount: Double = 0.0,

    @ColumnInfo(name = "paid_amount")
    var paidAmount: Double = 0.0,

    @ColumnInfo(name = "buyer_name")
    var buyerName: String,

    @ColumnInfo(name = "item_count")
    var itemCount: Int
)