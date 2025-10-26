package com.example.cashew.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cashew.data.dao.AccountDao
import com.example.cashew.data.dao.CategoryDao
import com.example.cashew.data.dao.TransactionDao
import com.example.cashew.data.entities.AccountEntity
import com.example.cashew.data.entities.CategoryEntity
import com.example.cashew.data.entities.TransactionEntity

@Database(
    entities = [TransactionEntity::class, AccountEntity::class, CategoryEntity::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun accountDao(): AccountDao
    abstract fun categoryDao(): CategoryDao

}