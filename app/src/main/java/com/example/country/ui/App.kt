package com.example.country.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.country.viewModel.CountryViewModel

@Composable
fun App() {
    var showCountryList by remember { mutableStateOf(false) }
    var selectedUrl by remember { mutableStateOf("https://restcountries.com/v3.1/all") }
    val viewModel: CountryViewModel = viewModel()

    if (showCountryList) {
        CountryListScreen(viewModel, selectedUrl)
    } else {
        HomeScreen(
            onNavigate = { url ->
                selectedUrl = url
                viewModel.fetchCountries(url) // Charger les données correctes
                showCountryList = true
            }
        )
    }
}



@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Karibu", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onNavigate("https://restcountries.com/v3.1/all") }) {
                Text(text = "Tous les pays")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onNavigate("https://restcountries.com/v3.1/region/africa") }) {
                Text(text = "Pays d'Afrique")
            }
        }
    }
}
