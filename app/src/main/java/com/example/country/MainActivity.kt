package com.example.country

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.country.ui.theme.CountryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var showCountryList by remember { mutableStateOf(false) }

    if (showCountryList) {
        CountryListScreen()
    } else {
        HomeScreen(onNavigate = { showCountryList = true })
    }
}

// 🏠 **Écran d'accueil**
@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "karibu",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigate) {
                Text(text = "voir les pays")
            }
        }
    }
}

// 🌍 **Écran liste des pays**
@Composable
fun CountryListScreen() {
    val countries = listOf(
        Country("RDC", "Kinshasa", "CD", R.drawable.image1),
        Country("USA", "Washington", "US", R.drawable.image2),
        Country("France", "Paris", "FR", R.drawable.image3)
    )

    Column {
        // 🔝 Logo et titre
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "Logo",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "M'bokas",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        // 📝 Liste des pays
        LazyColumn {
            items(countries) { country ->
                CountryItem(country)
            }
        }
    }
}

// 🏳 **Élément d'un pays**
@Composable
fun CountryItem(country: Country) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = country.imageRes),
            contentDescription = "Drapeau de ${country.name}",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = country.name, fontWeight = FontWeight.Bold)
            Text(text = "${country.capital} / ${country.code}", style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id =R.drawable.image1),
            contentDescription = "Voir plus",
            modifier = Modifier.size(24.dp)
        )
    }
}

// 🔍 **Prévisualisation**
@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    CountryTheme {
        App()
    }
}
