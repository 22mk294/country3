package com.example.country.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.country.Country
import com.example.country.model.CountryApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries = _countries.asStateFlow()

    private val api = CountryApi.create()

    fun fetchCountries(url: String) {
        viewModelScope.launch {
            try {
                _countries.value = api.getCountries(url)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
