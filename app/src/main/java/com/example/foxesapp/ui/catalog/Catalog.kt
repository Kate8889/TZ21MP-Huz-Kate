package com.example.foxesapp.ui.catalog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foxesapp.R
import com.example.foxesapp.model.Fox
import com.example.foxesapp.ui.fox.FoxCard
import com.example.foxesapp.ui.theme.FoxesAppTheme


@Composable
fun Catalog(
    foxes: List<Fox>,
    onSelected: (Fox) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            items(foxes) { fox ->
                FoxCard(fox = fox, onClick = { onSelected(fox) })
            }
        }
    }
}

@Preview
@Composable
fun CatalogPreview() {
    val fox = Fox(
        id = "1",
        name = "Ezee",
        breed = "House fox",
        sex = "female",
        age = 3,
        photo = R.drawable.house_fox
    )
    FoxesAppTheme(darkTheme = true) {
        Catalog(foxes = listOf(fox), onSelected = {})
    }
}