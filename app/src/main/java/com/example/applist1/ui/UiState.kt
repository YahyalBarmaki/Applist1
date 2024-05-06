package com.example.applist1.ui

import com.example.applist1.domain.Quote

data class UiState (
    val isLoading : Boolean = false,
    val error:String? = null,
    val quotes: List<Quote> = emptyList()
)




