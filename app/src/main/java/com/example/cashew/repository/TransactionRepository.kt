package com.example.cashew.repository

import com.example.cashew.data.dao.TransactionDao
import com.example.cashew.data.entities.TransactionEntity

class TransactionRepository(private val transactionDao: TransactionDao) {
    val allTransactions = transactionDao.getAllTransactions()

    suspend fun insertTransaction(transaction: TransactionEntity) {
        transactionDao.insertTransaction(transaction)
    }
}