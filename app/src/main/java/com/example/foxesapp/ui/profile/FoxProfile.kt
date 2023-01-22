package com.example.foxesapp.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxesapp.R
import com.example.foxesapp.model.Fox
import com.example.foxesapp.ui.theme.FoxesAppTheme


@Composable
fun FoxProfile(
    fox: Fox,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            item { ProfileHeader(avatar = fox.photo) }
            item {
                Text(
                    text = fox.name,
                    style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Medium),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    textAlign = TextAlign.Center
                )
            }
            item { Area("Breed", fox.breed) }
            item { Area("Sex", fox.sex) }
            item { Area("Age(month)", fox.age.toString()) }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                        .size(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Button(onClick = {}) {
                        Text(
                            text = "Feed Me",
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Medium)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FoxProfilePreview() {
    val fox = Fox(
        id = "1",
        name = "Ezee",
        breed = "House fox",
        sex = "female",
        age = 3,
        photo = R.drawable.house_fox
    )
    FoxesAppTheme(darkTheme = true) {
        FoxProfile(fox = fox)
    }
}
