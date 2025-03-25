package com.example.adabank.feature_app.data.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.model.TransactionHistory

@Dao
interface CardOperationDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertSendAgainData(sendAgainDto: SendAgainDto)

    @Query("SELECT * FROM SendAgainDto WHERE userID =:userID")
    fun getSendAgainData(userID: String) : List<SendAgainDto>

    @Query("DELETE FROM SendAgainDto")
    fun clearSendAgainData()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertTransactionData(transactionHistoryDto: TransactionHistoryDto)

    @Query("SELECT * FROM TransactionHistoryDto WHERE userID =:userID")
    fun getTransactionHistoryData(userID: String) : List<TransactionHistoryDto>

    @Query("DELETE FROM TransactionHistoryDto")
    fun clearTransactionHistoryData()
}

@Entity
data class SendAgainDto(
    @PrimaryKey(true) val id: Int,
    @ColumnInfo(defaultValue = "") val userID: String,
    @ColumnInfo(defaultValue = "") val image: String,
    @ColumnInfo(defaultValue = "") val name: String,
    @ColumnInfo(defaultValue = "") val bankCardNumber: String,
){
    fun toSendAgain() : SendAgain{
        return SendAgain(id, userID, image, name, bankCardNumber)
    }
}

@Entity
data class TransactionHistoryDto(
    @PrimaryKey(true) val id: Int,
    @ColumnInfo(defaultValue = "") val userID: String,
    @ColumnInfo(defaultValue = "") val image: String,
    @ColumnInfo(defaultValue = "") val title: String,
    @ColumnInfo(defaultValue = "") val date: String,
    @ColumnInfo(defaultValue = "") val price: String,
    @ColumnInfo(defaultValue = "") val sendTo: String,
){
    fun toTransactionHistory() : TransactionHistory{
        return TransactionHistory(id, userID, image, title, date, price, sendTo)
    }
}
