package com.example.marketplace.database
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice")
data class Invoice (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "buyer_name")
    var buyerName: String = "",

    @ColumnInfo(name = "total_amount")
    var totalAmount: Double = 0.0,

    @ColumnInfo(name = "paid_amount")
    var paidAmount: Double = 0.0,

    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "item_count")
    var itemCount: Int = 0
)