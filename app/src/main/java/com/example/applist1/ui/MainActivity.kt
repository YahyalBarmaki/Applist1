package com.example.applist1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.applist1.ui.theme.Applist1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Applist1Theme {
                // A surface container using the 'background' color from the theme
                val viewModel : MainViewModel = hiltViewModel()

                MyScreen(
                    onGetQuotes = {
                        viewModel.getQuote()
                    },
                    uiState = viewModel.uiState.value
                )
            }
        }
    }
}
