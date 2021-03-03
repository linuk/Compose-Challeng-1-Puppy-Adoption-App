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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.Dimen
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

val PET_CARD_SHAPE = shapes.large
private val PET_CARD_IMAGE_EXPANDED_HEIGHT = 400.dp
private val PET_CARD_IMAGE_FOLDED_HEIGHT = 200.dp

@ExperimentalAnimationApi
@Composable
fun PetCard(
    bitmap: ImageBitmap?,
    name: String,
    description: String,
    onClick: () -> Unit = {},
    expanded: Boolean = true
) {
    val imageHeight = animateDpAsState(
        if (expanded) PET_CARD_IMAGE_EXPANDED_HEIGHT else PET_CARD_IMAGE_FOLDED_HEIGHT
    ).value

    Column(
        modifier = Modifier
            .clip(PET_CARD_SHAPE)
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            color = (Color.LightGray),
            modifier = Modifier
                .height(imageHeight)
                .fillMaxWidth()
        ) {
            if (bitmap != null) {
                Image(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    bitmap = bitmap,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
        AnimatedVisibility(expanded) {
            Column(Modifier.padding(Dimen.medium)) {
                Text(
                    text = name,
                    style = typography.h6
                )
                Text(
                    text = description,
                    style = typography.subtitle1,
                )
            }
        }
    }
}
