import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import model.Country

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    MaterialTheme {
        val countries by produceState(emptyList<Country>()) {
            value = CountriesRepository.get()
        }
        Scaffold(topBar = { TopAppBar(title = { Text(text = "Countries") }) }
        ) { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(countries) { country ->
                    ListItem(
                        text = { Text(text = country.name) },
                        secondaryText = { Text(text = country.code) },
                        icon = { Text(text = country.emoji) }
                    )
                }
            }
        }
    }
}