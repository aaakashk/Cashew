package com.example.cashew.data.mappers

import com.example.cashew.data.entities.AccountEntity
import com.example.cashew.domain.model.Account

fun AccountEntity.toDomain(): Account {
    return Account(
        id = this.id,
        name = this.name,
        balance = this.balance,
        transactionsCount = this.transactionsCount,
        isPrimary = this.isPrimary
    )
}