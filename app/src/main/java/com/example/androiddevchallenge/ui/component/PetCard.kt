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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.model.Fixtures
import com.example.androiddevchallenge.ui.theme.Dimen
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

private val PET_CARD_SHAPE = shapes.large

@ExperimentalAnimationApi
@Composable
fun PetCard(
    bitmap: ImageBitmap?,
    name: String,
    description: String,
    onClick: () -> Unit = {},
    elevation: Dp = Dimen.small,
    zIndex: Float = 1.0F,
) {
    Surface(
        shape = PET_CARD_SHAPE,
        elevation = elevation,
        modifier = Modifier.wrapContentHeight().zIndex(zIndex)
    ) {
        Column(
            modifier = Modifier
                .clip(PET_CARD_SHAPE)
                .clickable(onClick = onClick)
                .background(MaterialTheme.colors.surface),
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                color = (Color.LightGray),
                modifier = Modifier.height(200.dp).fillMaxWidth()
            ) {
                if (bitmap != null)
                    Image(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        bitmap = bitmap,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
            }
            Column(Modifier.padding(Dimen.medium)) {
                Text(
                    text = name,
                    style = typography.h6
                )
                Text(
                    maxLines = 2,
                    text = description,
                    style = typography.subtitle1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetCardLightPreview() {
    MyTheme {
        PetCard(
            name = Fixtures.PET_LIST[0].name,
            description = Fixtures.PET_LIST[0].description,
            bitmap = Fixtures.PET_LIST[0].image,
        )
    }
}
