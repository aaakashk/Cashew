package com.example.cashew.domain.model

sealed interface TransactionType {
    val isExpense: Boolean
        get() = this is Expense
}

sealed class Expense : TransactionType {
    // these don't have status so they are objects,
    // i.e., they don't need to hold data
    object Default : Expense()
    object Lent : Expense()

    // these have status
    data class Upcoming(override val status: PaidStatus = PaidStatus.NOT_PAID) : Expense(),
        TrackableTransaction

    data class Repetitive(override val status: PaidStatus = PaidStatus.NOT_PAID) : Expense(),
        TrackableTransaction

    data class Subscription(override val status: PaidStatus = PaidStatus.NOT_PAID) : Expense(),
        TrackableTransaction
}

sealed class Income : TransactionType {
    // no status
    object Default : Income()
    object Borrowed : Income()

    // status
    data class Upcoming(override val status: PaidStatus = PaidStatus.NOT_PAID) : Income(),
        TrackableTransaction

    data class Repetitive(override val status: PaidStatus = PaidStatus.NOT_PAID) : Income(),
        TrackableTransaction
}