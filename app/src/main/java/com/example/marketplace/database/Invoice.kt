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
import com.example.marketplace.util.AppConstant

@Entity(tableName = "invoice")
data class Invoice (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "buyer_name")
    var buyerName: String = AppConstant.EMPTY_STRING,

    @ColumnInfo(name = "client_name")
    var clientName: String = AppConstant.EMPTY_STRING,

    @ColumnInfo(name = "total_amount")
    var totalAmount: Double = 0.0,

    @ColumnInfo(name = "paid_amount")
    var paidAmount: Double = 0.0,

    @ColumnInfo(name = "sub_total")
    var subTotal: Double = 0.0,

    @ColumnInfo(name = "discount")
    var discount: Double = 0.0,

    @ColumnInfo(name = "tax")
    var tax: Double = 0.0,

    @ColumnInfo(name = "shipping")
    var shipping: Double = 0.0,

    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "item_count")
    var itemCount: Int = 0
)

@Entity(tableName = "invoice_item")
data class InvoiceItem (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "invoice_id")
    var invoiceId: Long = 0L,

    @ColumnInfo(name = "product_name")
    var productName: String = AppConstant.EMPTY_STRING,

    @ColumnInfo(name = "product_image_url")
    var productImageUrl: String = AppConstant.EMPTY_STRING,

    @ColumnInfo(name = "quantity")
    var quantity: Int = 0,

    @ColumnInfo(name = "cost")
    var cost: Double = 0.0,

    @ColumnInfo(name = "selling_price")
    var sellingPrice: Double = 0.0,

    @ColumnInfo(name = "discount")
    var discount: Double = 0.0,
)