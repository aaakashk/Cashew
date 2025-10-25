package com.example.cashew.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val balance: Long,
    @ColumnInfo(name = "transactions_count")
    val transactionsCount: Int,
    @ColumnInfo(name = "decimal_places", defaultValue = "2")
    val decimalPlaces: Int,
    val currency: String,
    @ColumnInfo(name = "is_primary", defaultValue = "false")
    val isPrimary: Boolean,
    @ColumnInfo(name = "created_at", defaultValue = "DEFAULT_TIMESTAMP")
    val createAt: Long,
    @ColumnInfo(name = "modified_at", defaultValue = "DEFAULT_TIMESTAMP")
    val modifiedAt: Long,
)