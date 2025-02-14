package com.example.country.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.country.viewModel.CountryViewModel

@Composable
fun CountryListScreen(viewModel: CountryViewModel, baseUrl: String) {
    val countries by viewModel.countries.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column {
        SearchBar(query = searchQuery, onQueryChanged = { searchQuery = it })
        LazyColumn {
            items(countries.filter { it.name.common.contains(searchQuery, ignoreCase = true) }) { country ->
                CountryItem(country)
            }
        }
    }
}


