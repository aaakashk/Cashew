package com.example.cashew.repository

import com.example.cashew.data.dao.CategoryDao
import com.example.cashew.data.entities.CategoryEntity

class CategoryRepository(private val categoryDao: CategoryDao) {
    val allCategories = categoryDao.getAllCategories()

    suspend fun insertCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }
}