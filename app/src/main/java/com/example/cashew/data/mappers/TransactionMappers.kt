package com.example.cashew.data.mappers

import com.example.cashew.data.entities.TransactionEntity
import com.example.cashew.domain.model.Expense
import com.example.cashew.domain.model.Income
import com.example.cashew.domain.model.PaidStatus
import com.example.cashew.domain.model.Transaction

fun TransactionEntity.toDomainModel(): Transaction {
    val domainType = when (this.type) {
        // expense
        "EXPENSE_DEFAULT" -> Expense.Default
        "EXPENSE_LENT" -> Expense.Lent
        "EXPENSE_SUBSCRIPTION" -> Expense.Subscription(this.status!!)
        "EXPENSE_REPETITIVE" -> Expense.Repetitive(this.status!!)
        "EXPENSE_UPCOMING" -> Expense.Upcoming(this.status!!)
        // income
        "INCOME_DEFAULT" -> Income.Default
        "INCOME_BORROWED" -> Income.Borrowed
        "INCOME_REPETITIVE" -> Income.Repetitive(this.status!!)
        "INCOME_UPCOMING" -> Income.Upcoming(this.status!!)
        else -> throw IllegalArgumentException("Invalid transaction type: ${this.type}")
    }
    return Transaction(
        id = this.id,
        title = this.title,
        amount = this.amount,
        note = this.note,
        type = domainType,
        accountId = this.accountId,
        categoryId = this.categoryId,
    )
}

fun Transaction.toEntity(): TransactionEntity {
    val entityType: String
    val entityStatus: PaidStatus?

    when (val domainType = this.type) {
        // expense
        is Expense.Default -> {
            entityType = "EXPENSE_NORMAL"; entityStatus = null
        }

        is Expense.Lent -> {
            entityType = "EXPENSE_LENT"; entityStatus = null
        }

        is Expense.Subscription -> {
            entityType = "EXPENSE_SUBSCRIPTION"; entityStatus = domainType.status
        }

        is Expense.Repetitive -> {
            entityType = "EXPENSE_REPETITIVE"; entityStatus = domainType.status
        }

        is Expense.Upcoming -> {
            entityType = "EXPENSE_UPCOMING"; entityStatus = domainType.status
        }
        // income
        is Income.Default -> {
            entityType = "INCOME_NORMAL"; entityStatus = null
        }

        is Income.Borrowed -> {
            entityType = "INCOME_BORROWED"; entityStatus = null
        }

        is Income.Repetitive -> {
            entityType = "INCOME_REPETITIVE"; entityStatus = domainType.status
        }

        is Income.Upcoming -> {
            entityType = "INCOME_UPCOMING"; entityStatus = domainType.status
        }
    }
    return TransactionEntity(
        id = this.id,
        title = this.title,
        amount = this.amount,
        note = this.note,
        type = entityType,
        status = entityStatus,
        createdAt = System.currentTimeMillis(),
        modifiedAt = System.currentTimeMillis(),
        accountId = this.accountId,
        categoryId = this.categoryId,
    )
}