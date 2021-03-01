/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class PetViewModel : ViewModel() {
    private val map = HashMap<String, ImageBitmap>()
    var petList by mutableStateOf(Fixtures.PET_LIST)

    fun loadImage(pet: Pet, onImageLoaded: (ImageBitmap) -> Unit) {
        if (map.containsKey(pet.imageUrl)) {
            Log.i("TAG", "Reuse ${pet.name} image in loadImage")

            petList = petList.toMutableList().also { newPetList ->
                newPetList.find { it.imageUrl == pet.imageUrl }?.image = map[pet.imageUrl]
            }
            map[pet.imageUrl]?.let { onImageLoaded(it) }
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val connection = URL(pet.imageUrl).openConnection()
                connection.useCaches = true
                val imageBitmap = BitmapFactory.decodeStream(connection.getInputStream())
                    .asImageBitmap()

                map[pet.imageUrl] = imageBitmap

                petList = petList.toMutableList().also { newPetList ->
                    newPetList.find { it.imageUrl == pet.imageUrl }?.image = imageBitmap
                }

                onImageLoaded(imageBitmap)
                Log.i("TAG", "Loaded ${pet.name} image")
            }
        }
    }
}
