package com.example.applist1.data.datasource

import com.example.applist1.domain.ResponseQuote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {

    @GET("/quotes")
     suspend fun getQuote() :Response<ResponseQuote>
}