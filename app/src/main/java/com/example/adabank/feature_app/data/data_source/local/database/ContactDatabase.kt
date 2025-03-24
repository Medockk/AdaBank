package com.example.adabank.feature_app.data.data_source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.adabank.feature_app.data.data_source.local.ContactDao
import com.example.adabank.feature_app.data.data_source.local.ContactDto

@Database(entities = [ContactDto::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contact: ContactDao

    companion object{
        fun createDatabase(context: Context) : ContactDatabase{
            return Room.databaseBuilder(context, ContactDatabase::class.java, "contacts.db").build()
        }
    }
}