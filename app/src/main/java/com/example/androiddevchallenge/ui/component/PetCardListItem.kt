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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.model.Pet

const val CARD_Z_INDEX_CHECKED = 2.0F
const val CARD_Z_INDEX_UNCHECKED = 1.0F

@ExperimentalAnimationApi
@Composable
fun PetCardListItem(
    pet: Pet,
    isChecked: Boolean,
    visible: Boolean = true,
    elevation: Dp,
    onPetShown: (pet: Pet, callback: (ImageBitmap) -> Unit) -> Unit,
    onClick: () -> Unit
) {
    val image = remember { mutableStateOf(pet.image) }
    val bottomPadding = animateDpAsState(if (visible) CARD_SPACE else 0.dp)

    onPetShown(pet) {
        image.value = it
    }

    Surface(
        shape = PET_CARD_SHAPE,
        elevation = elevation,
        modifier = Modifier.padding(bottom = bottomPadding.value)
            .wrapContentHeight()
            .zIndex(if (isChecked) CARD_Z_INDEX_CHECKED else CARD_Z_INDEX_UNCHECKED)
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            PetCard(
                bitmap = image.value,
                name = pet.name,
                description = pet.description,
                onClick = onClick,
                expanded = visible && isChecked
            )
        }
    }
}
