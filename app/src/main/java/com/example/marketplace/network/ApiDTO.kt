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


data class InvoiceItemDTO(
    val id: Long,
    val total: Double,
    val paidAmount: Double,
    val createdAt: Long,
    val buyerName: String,
    val itemCount: Int
)