package com.example.cashew.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cashew.data.entities.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM accounts where id = :id")
    fun getAccountById(id: Int): AccountEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAccount(account: AccountEntity)
}