package com.example.cashew.data

import android.content.Context
import androidx.room.Room
import com.example.cashew.data.dao.AccountDao
import com.example.cashew.data.dao.CategoryDao
import com.example.cashew.data.dao.TransactionDao
import com.example.cashew.repository.AccountRepository
import com.example.cashew.repository.CategoryRepository
import com.example.cashew.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "cashew")
            .fallbackToDestructiveMigration(true) // delete all tables if migration not done successfully
            .build()
    }

    @Provides
    fun provideTransactionDao(appDatabase: AppDatabase): TransactionDao {
        return appDatabase.transactionDao()
    }

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }

    @Provides
    fun provideAccountDao(appDatabase: AppDatabase): AccountDao {
        return appDatabase.accountDao()
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(transactionDao: TransactionDao): TransactionRepository {
        return TransactionRepository(transactionDao)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryDao: CategoryDao): CategoryRepository {
        return CategoryRepository(categoryDao)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(accountDao: AccountDao): AccountRepository {
        return AccountRepository(accountDao)
    }
}