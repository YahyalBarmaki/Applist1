package com.example.applist1.data.repository

import com.example.applist1.data.datasource.QuoteApi
import com.example.applist1.util.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuotesRepository @Inject constructor(
    private val api: QuoteApi
) {
    suspend fun getQuotes() = flow {
        emit(Result.Loading())
        val quotes = api.getQuote().body()?.quotes
        emit(Result.Success(quotes))
    }.catch { error ->
        emit(Result.Error(error.message!!))
    }
}