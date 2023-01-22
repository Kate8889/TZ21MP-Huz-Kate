package com.example.foxesapp.model

import androidx.lifecycle.ViewModel
import com.example.foxesapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FoxesViewModel: ViewModel() {
    val foxes = MutableStateFlow<List<Fox>>(emptyList())

    fun getById(id: String) = foxes.value.first { fox -> fox.id == id }

    init {
        foxes.update {
            mutableListOf(
                Fox(
                    id = "1",
                    name = "Ezee",
                    breed = "House fox",
                    sex = "female",
                    age = 3,
                    photo = R.drawable.house_fox
            ),
            Fox(
                id = "2",
                name = "Mirak",
                breed = "Fenek ",
                sex = "male",
                age = 4,
                photo = R.drawable.fenek
            ),
            Fox(
                id = "3",
                name = "Tom",
                breed = "Vulpes chama",
                sex = "male",
                age = 8,
                photo = R.drawable.image_3
            ),
            Fox(
                id = "4",
                name = "Cleopatra",
                breed = "Vulpes cana",
                sex = "female",
                age = 6,
                photo = R.drawable.fox_4
            ),
            Fox(
                id = "5",
                name = "Matilda",
                breed = "Vulpes macrotis",
                sex = "female",
                age = 5,
                photo = R.drawable.fox_5
            ),
            Fox(
                id = "6",
                name = "Albus",
                breed = "Vulpes pallida",
                sex = "male",
                age = 17,
                photo = R.drawable.fox_6
            ),
            Fox(
                id = "7",
                name = "Pile",
                breed = "Vulpes rueppellii",
                sex = "female",
                age = 2,
                photo = R.drawable.fox_7
            ),
            Fox(
                id = "8",
                name = " Rocky",
                breed = " Vulpes velox",
                sex = "male",
                age = 9,
                photo = R.drawable.fox_8
            )
            )
        }
    }
}
