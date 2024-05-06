package com.example.applist1.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applist1.data.repository.QuotesRepository
import com.example.applist1.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: QuotesRepository
):ViewModel() {

    val uiState = mutableStateOf(
        UiState()
    )
    init {
        getQuote()
    }
    fun getQuote(){
        viewModelScope.launch {
            repository.getQuotes().collect{result->
                when(result){
                    is Result.Loading->{
                       uiState.value = UiState(isLoading = true)
                    }
                    is Result.Success->{
                        uiState.value = UiState(isLoading = false, quotes = result.data!!)
                    }
                    is Result.Error->{
                        uiState.value = UiState(error = result.message)
                    }
                }

            }
        }
    }

}