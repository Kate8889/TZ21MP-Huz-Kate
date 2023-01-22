package com.example.foxesapp.ui.fox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxesapp.R
import com.example.foxesapp.model.Fox
import com.example.foxesapp.ui.theme.FoxesAppTheme


@Composable
fun FoxCard(
    fox: Fox,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val padding = 14.dp
    val color = Color(red = 54, green = 50, blue = 43, alpha = 139)
    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding / 2
            )
            .fillMaxWidth()
            .background(
                color,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color,
                shape = RoundedCornerShape(10.dp)
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth(10f)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = fox.photo),
                contentDescription = "Avatar",
                modifier
                    .size(90.dp)
                    .padding(
                        top = 2.dp,
                        start = 6.dp,
                        end = 0.dp,
                        bottom = 2.dp
                    )
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.size(padding))
            Column {
                Text(
                    text = fox.name,
                    style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = fox.breed,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Light,
                        color = Color.LightGray
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun FoxCardPreview() {
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
            FoxCard(fox, {})
        }
    }
}

