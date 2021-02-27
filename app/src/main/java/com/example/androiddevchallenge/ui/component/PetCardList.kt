package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Fixtures
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.Dimen
import com.example.androiddevchallenge.ui.theme.MyTheme

private val CARD_SPACE = Dimen.large

@Composable
fun PetCardList(pets: List<Pet>) {
    LazyColumn(
        contentPadding = PaddingValues(CARD_SPACE)
    ) {
        items(pets) {
            PetCard(name = it.name, description = it.description)
            Spacer(Modifier.height(CARD_SPACE).fillMaxWidth())
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetCardListLightPreview() {
    MyTheme {
        Surface(Modifier.background(MaterialTheme.colors.background)) {
            PetCardList(Fixtures.PET_LIST)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PetCardListDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(Modifier.background(MaterialTheme.colors.background)) {
            PetCardList(Fixtures.PET_LIST)
        }
    }
}