package com.example.foxesapp.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxesapp.R
import com.example.foxesapp.model.Fox
import com.example.foxesapp.ui.theme.FoxesAppTheme


@Composable
fun Area(
    areaName: String,
    areaValue: String,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        val padding = 20.dp
        Column(
            modifier
                .fillMaxWidth()
                .padding(
                    top = padding / 2,
                    start = padding,
                    end = padding,
                    bottom = padding / 2
                )
        ) {
            Text(
                text = areaName,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Light)
            )
            Text(
                text = areaValue,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 1.dp,
                        end = 5.dp,
                        top = 1.dp,
                        bottom = 3.dp
                    )
            )
        }
    }
}

@Preview
@Composable
fun FieldPreview() {
    val fox = Fox(
        id = "1",
        name = "Ezee",
        breed = "House fox",
        sex = "female",
        age = 3,
        photo = R.drawable.house_fox
    )

    FoxesAppTheme(darkTheme = true) {
        Surface {
            Area("Age(month)", fox.age.toString())

        }
    }
}