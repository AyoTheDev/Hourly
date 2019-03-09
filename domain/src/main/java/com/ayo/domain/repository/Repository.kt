package com.ayo.domain.repository

interface Repository<T> {

    suspend fun getAll(forceRefresh: Boolean = false): List<T>?

    suspend fun addAll(list: List<T>): List<Long>

    suspend fun add(data: T): Long

    suspend fun get(id: Long): T?

}