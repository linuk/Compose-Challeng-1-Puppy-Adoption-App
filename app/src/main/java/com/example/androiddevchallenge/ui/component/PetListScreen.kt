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
package com.example.androiddevchallenge.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.Dimen

@ExperimentalAnimationApi
@Composable
fun PetListScreen(
    petList: List<Pet>,
    loadPetImage: (imageUrl: String, (ImageBitmap) -> Unit) -> Unit,
) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopAppBar(
                title = { Text(stringResource(id = R.string.pet_list_screen_title)) },
                backgroundColor = MaterialTheme.colors.background,
                elevation = Dimen.small,
                modifier = Modifier.zIndex(100F)
            )
            PetCardList(petList) { pet, onPetImageLoaded ->
                if (pet.image == null) {
                    loadPetImage(pet.imageUrl, onPetImageLoaded)
                }
            }
        }
    }
}
