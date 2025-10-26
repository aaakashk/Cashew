package com.example.cashew.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cashew.domain.model.PaidStatus

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = AccountEntity::class,
            parentColumns = ["id"],
            childColumns = ["account_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("account_id"), Index("category_id")]
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String?,
    val amount: Long,
    val note: String?,
    val type: String,
    val status: PaidStatus?,
    @ColumnInfo(name = "created_at", defaultValue = "DEFAULT_TIMESTAMP")
    val createdAt: Long,
    @ColumnInfo(name = "modified_at", defaultValue = "DEFAULT_TIMESTAMP")
    val modifiedAt: Long,
    @ColumnInfo(name = "account_id")
    val accountId: Int,
    @ColumnInfo(name = "category_id")
    val categoryId: Int?,
)
