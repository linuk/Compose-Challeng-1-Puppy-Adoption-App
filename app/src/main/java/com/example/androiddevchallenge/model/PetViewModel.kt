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

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Request.Method.GET
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class PetViewModel : ViewModel() {
    private val map = HashMap<String, ImageBitmap>()
    var petList by mutableStateOf<List<Pet>>(mutableListOf())

    fun loadCatBreeds(context: Context) {
        val stringRequest = JsonArrayRequest(
            GET, ENDPOINT_BREEDS, null,
            { response ->
                petList = catBreedsListener(response)
            },
            { error ->
                error.message?.let { Log.i("PetViewModel", it) }
            }
        )
        Volley.newRequestQueue(context).add(stringRequest)
    }

    private fun catBreedsListener(response: JSONArray) = ArrayList<Pet>().also { list ->
        for (i in 0 until response.length()) {
            response.getJSONObject(i).let { breed ->
                if (isCatBreedJSONValid(breed)) {
                    list.add(parseBreedToPet(breed))
                }
            }
        }
    }

    fun loadImage(imageUrl: String, onImageLoaded: ((ImageBitmap) -> Unit)?) {
        if (map.containsKey(imageUrl)) {
            petList = petList.toMutableList().also { newPetList ->
                newPetList.find { it.imageUrl == imageUrl }?.image = map[imageUrl]
            }
            map[imageUrl]?.let { imageBitmap -> onImageLoaded?.let { it(imageBitmap) } }
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val connection = URL(imageUrl).openConnection()
                connection.useCaches = true
                val imageBitmap = BitmapFactory.decodeStream(connection.getInputStream())
                    .asImageBitmap()

                map[imageUrl] = imageBitmap

                petList = petList.toMutableList().also { newPetList ->
                    newPetList.find { it.imageUrl == imageUrl }?.image = imageBitmap
                }

                onImageLoaded?.let { it(imageBitmap) }
            }
        }
    }

    companion object {
        private const val ENDPOINT_BREEDS = "https://api.thecatapi.com/v1/breeds"
        private const val FIELD_NAME = "name"
        private const val FIELD_DESCRIPTION = "description"
        private const val FIELD_IMAGE = "image"
        private const val FIELD_URL = "url"

        private fun isCatBreedJSONValid(jsonObject: JSONObject) =
            jsonObject.has(FIELD_NAME) &&
                jsonObject.has(FIELD_DESCRIPTION) &&
                jsonObject.has(FIELD_IMAGE) &&
                jsonObject.getJSONObject(FIELD_IMAGE).has(FIELD_URL)

        private fun parseBreedToPet(jsonObject: JSONObject) = Pet(
            name = jsonObject.getString(FIELD_NAME),
            description = jsonObject.getString(FIELD_DESCRIPTION),
            imageUrl = jsonObject.getJSONObject(FIELD_IMAGE)
                .getString(FIELD_URL)
                .toString()
        )
    }
}
