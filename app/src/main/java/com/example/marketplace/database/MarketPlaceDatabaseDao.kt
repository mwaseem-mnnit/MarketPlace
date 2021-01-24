package com.example.marketplace.database
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MarketPlaceDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInvoice(invoice: Invoice)

    @Update
    suspend fun updateInvoice(invoice: Invoice)

    @Query("SELECT * from invoice WHERE id = :key")
    suspend fun get(key: Long): Invoice

    @Query("DELETE FROM invoice")
    suspend fun clearInvoice()

    @Query("SELECT * FROM invoice ORDER BY id DESC")
    fun getAllInvoice(): LiveData<List<Invoice>>

}
