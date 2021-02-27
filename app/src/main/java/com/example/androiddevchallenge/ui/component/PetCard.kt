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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Fixtures
import com.example.androiddevchallenge.ui.theme.Dimen
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

private val PET_CARD_SHAPE = shapes.large
private val PET_CARD_ELEVATION = Dimen.small

@Composable
fun PetCard(name: String, description: String) {
    Surface(
        shape = PET_CARD_SHAPE,
        elevation = PET_CARD_ELEVATION,
        modifier = Modifier.background(MaterialTheme.colors.background)
            .wrapContentHeight()
    ) {
        Column(
            Modifier
                .clip(PET_CARD_SHAPE)
                .clickable { }
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
//                painter = painterResource(R.drawable.cat_1),
                contentDescription = "A cat",
                contentScale = ContentScale.FillWidth
            )
            Column(Modifier.padding(Dimen.medium)) {
                Text(text = name, style = typography.h6)
                Text(maxLines = 3, text = description, style = typography.subtitle1)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetCardLightPreview() {
    MyTheme {
        PetCard(Fixtures.PET_LIST[0].name, Fixtures.PET_LIST[0].description)
    }
}

 @Preview("Dark Theme", widthDp = 360, heightDp = 640)
 @Composable
 fun PetCardDarkPreview() {
    MyTheme(darkTheme = true) {
        PetCard(Fixtures.PET_LIST[0].name, Fixtures.PET_LIST[0].description)
    }
 }
