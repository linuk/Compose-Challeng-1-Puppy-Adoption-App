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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pet

@ExperimentalAnimationApi
@Composable
fun PetCardListItem(
    pet: Pet,
    isChecked: Boolean,
    elevation: Dp,
    onPetShown: (pet: Pet, callback: (ImageBitmap) -> Unit) -> Unit,
    onClick: () -> Unit
) {
    val image = remember { mutableStateOf(pet.image) }

    onPetShown(pet) {
        image.value = it
    }

    Surface(
        Modifier.fillMaxHeight(if (image.value == null) 0F else 1F)
            .height(if (image.value == null) 0.dp else 100.dp)
    ) {
        PetCard(
            bitmap = image.value,
            name = if (isChecked) "${pet.name} ✅" else pet.name,
            description = pet.description,
            elevation = elevation,
            onClick = onClick,
            zIndex = if (isChecked) 2.0F else 1.0F,
        )
    }

    Spacer(Modifier.height(CARD_SPACE).fillMaxWidth())
}
