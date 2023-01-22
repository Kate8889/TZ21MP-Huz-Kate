package com.example.foxesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foxesapp.model.FoxesViewModel
import com.example.foxesapp.ui.catalog.Catalog
import com.example.foxesapp.ui.profile.FoxProfile
import com.example.foxesapp.ui.theme.FoxesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: FoxesViewModel by viewModels()
        setContent {
            FoxesAppTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: FoxesViewModel) {
    val state by viewModel.foxes.collectAsState()
    var selectedId by remember {
        mutableStateOf<String?>(value = null)
    }
    Crossfade(targetState = selectedId) { id ->
        if (id == null) {
            Catalog(foxes = state, onSelected = { fox ->
                selectedId = fox.id
            })
        } else {
            FoxProfile(fox = viewModel.getById(id))
            BackHandler() {
                selectedId = null
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoxesAppTheme(darkTheme = true) {
        MainScreen(FoxesViewModel())
    }
}