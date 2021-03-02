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
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.Dimen

val CARD_SPACE = Dimen.large
private const val INDEX_UNCHECKED = -1

@ExperimentalAnimationApi
@Composable
fun PetCardList(
    pets: List<Pet>,
    onPetShown: (pet: Pet, callback: (ImageBitmap) -> Unit) -> Unit
) {
    val clickedIndex = remember { mutableStateOf(INDEX_UNCHECKED) }
    Column(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(horizontal = CARD_SPACE),
            text = stringResource(id = R.string.pet_list_screen_title),
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.ExtraLight,
        )
        LazyColumn(
            contentPadding = PaddingValues(CARD_SPACE)
        ) {
            itemsIndexed(pets) { index, pet ->
                val isChecked = clickedIndex.value == index
                PetCardListItem(
                    pet = pet,
                    isChecked = isChecked,
                    elevation = animateDpAsState(getCardElevation(isChecked)).value,
                    onPetShown = onPetShown,
                    onClick = {
                        clickedIndex.value = if (isChecked) INDEX_UNCHECKED else index
                    }
                )
            }
        }
    }
}

fun getCardElevation(isChecked: Boolean): Dp = if (isChecked) Dimen.xxxlarge else Dimen.xxxsmall
