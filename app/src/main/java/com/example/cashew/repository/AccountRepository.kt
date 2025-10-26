package com.example.cashew.repository

import com.example.cashew.data.dao.AccountDao
import com.example.cashew.data.entities.AccountEntity
import com.example.cashew.data.mappers.toDomain
import com.example.cashew.domain.model.Account
import kotlinx.coroutines.flow.map

class AccountRepository(private val accountDao: AccountDao) {
    val allAccounts = accountDao.getAllAccounts().map { entityList ->
        entityList.map { it.toDomain() }
    }

    suspend fun addAccount(account: Account) {
        val now = System.currentTimeMillis()
        val newAccount = AccountEntity(
            name = account.name,
            balance = account.balance,
            transactionsCount = account.transactionsCount,
            isPrimary = account.isPrimary,
            decimalPlaces = account.decimalPlaces,
            currency = account.currency,
            createAt = now,
            modifiedAt = now
        )
        accountDao.insertAccount(newAccount)
    }
}