package com.example.cashew.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "transactions_count", defaultValue = "0")
    val transactionsCount: Int,
    @ColumnInfo(name = "created_at", defaultValue = "DEFAULT_TIMESTAMP")
    val createdAt: Long,
    @ColumnInfo(name = "modified_at", defaultValue = "DEFAULT_TIMESTAMP")
    val modifiedAt: Long,
)