package com.example.adabank.feature_app.data.data_source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.adabank.feature_app.data.data_source.local.CardOperationDao
import com.example.adabank.feature_app.data.data_source.local.SendAgainDto
import com.example.adabank.feature_app.data.data_source.local.TransactionHistoryDto

@Database(entities = [TransactionHistoryDto::class, SendAgainDto::class], version = 1)
abstract class CardOperationsDatabase : RoomDatabase() {

    abstract val cardOperationDao: CardOperationDao

    companion object{
        fun createDatabase(context: Context) : CardOperationsDatabase{
            return Room.databaseBuilder(context, CardOperationsDatabase::class.java, "card_operation.db").build()
        }
    }
}