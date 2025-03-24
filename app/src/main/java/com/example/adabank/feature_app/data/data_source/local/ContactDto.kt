package com.example.adabank.feature_app.data.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.example.adabank.feature_app.domain.model.Contact

@Entity
data class ContactDto(
    @PrimaryKey(true) val id: Int,
    @ColumnInfo(defaultValue = "") val userID: String,
    @ColumnInfo(defaultValue = "") val icon: String,
    @ColumnInfo(defaultValue = "") val name: String,
    @ColumnInfo(defaultValue = "") val bankCardNumber: String,
){
    fun toContact() : Contact{
        return Contact(id, userID, icon, name, bankCardNumber)
    }
}

@Dao
interface ContactDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertData(contactDto: ContactDto)

    @Query("SELECT * FROM CONTACTDTO WHERE userID = :userID")
    fun getData(userID: String) : List<ContactDto>

    @Query("DELETE FROM ContactDto")
    fun clearData()
}