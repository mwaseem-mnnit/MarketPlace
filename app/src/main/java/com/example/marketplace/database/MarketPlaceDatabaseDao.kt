package com.example.marketplace.database
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarketPlaceDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoice(invoice: Invoice)

    @Update
    suspend fun updateInvoice(invoice: Invoice)

    @Query("SELECT * from invoice WHERE id = :key")
    fun getInvoice(key: Long): LiveData<Invoice>

    @Query("DELETE FROM invoice")
    suspend fun clearInvoice()

    @Query("SELECT * FROM invoice ORDER BY id DESC")
    fun getAllInvoice(): LiveData<List<Invoice>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoiceItem(invoiceItem: InvoiceItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoiceItems(invoiceItems: List<InvoiceItem>)

    @Query("SELECT * FROM invoice_item where invoice_id = :key ORDER BY id DESC")
    fun getInvoiceItem(key: Long): LiveData<List<InvoiceItem>>

    @Query("SELECT * FROM invoice_item ORDER BY id DESC")
    fun getInvoiceItemAll(): LiveData<List<InvoiceItem>>
}
