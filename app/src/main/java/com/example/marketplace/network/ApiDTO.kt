/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
package com.example.marketplace.network

data class ResponseData<T>(
    val errorCode: Int,
    val errorMessage: String,
    val data: T?
)

data class PaginatedResponse<T>(
    val lastSeen: Int,
    val total: Int,
    val dataList: List<T>?
)


data class InvoiceRowDTO(
    val id: Long,
    val total: Double,
    val paidAmount: Double,
    val subTotal: Double,
    val shipping: Double,
    val tax: Double,
    val discount: Double,
    val createdAt: Long,
    val buyerName: String,
    val clientName: String,
    val itemCount: Int
)

data class InvoiceDetailDTO(
    val id: Long,
    val createdAt: Long,
    val seller: TransactingEntityDTO,
    val buyer: TransactingEntityDTO,
    val items: List<InvoiceItemDTO>?
)

data class  TransactingEntityDTO(
    val name: String,
    val mobile: String,
    val gstIN: String?,
    val address: String?
)

data class InvoiceItemDTO(
    val id: Long,
    val productName: String,
    val productImageUrl: String?,
    val quantity: Int,
    val cost: Double,
    val sellingPrice: Double,
    val discount: Double
)