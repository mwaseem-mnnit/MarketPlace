package com.example.marketplace.database
/*
 *   created by mohdwaseem
 *   created on 24/1/21
 *   Time: 8:13 PM
 *   To change this template use File | Settings | File and Code Templates.
*/
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Invoice::class, InvoiceItem::class], version = 3, exportSchema = false)
abstract class MarketPlaceDatabase : RoomDatabase() {
    abstract val marketPlaceDatabaseDao: MarketPlaceDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: MarketPlaceDatabase? = null

        fun getInstance(context: Context): MarketPlaceDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            MarketPlaceDatabase::class.java,
                            "market_place_database")
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
