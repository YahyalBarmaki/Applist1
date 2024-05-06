package com.example.applist1.domain

data class ResponseQuote(
    val quotes :List<Quote>,
    val total : Int
)
