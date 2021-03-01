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

import androidx.compose.ui.graphics.ImageBitmap

data class Pet(
    var name: String,
    val description: String,
    var imageUrl: String = "https://cdn2.thecatapi.com/images/xnsqonbjW.jpg",
    var image: ImageBitmap? = null
)

object Fixtures {
    val PET_LIST = listOf(
        Pet(
            "Bengal",
            "Bengals are a lot of fun to live with, but they're definitely not the cat for everyone, or for first-time cat owners. Extremely intelligent, curious and active, they demand a lot of interaction and woe betide the owner who doesn't provide it.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.bRqN8qi8TGVGqn4c6fk1LwHaKO%26pid%3DApi&f=1"
        ),
        Pet(
            "Abyssinian",
            "The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.sWIi4QprcqGc_ALuhfH4XwHaFj%26pid%3DApi&f=1"
        ),
        Pet(
            "Cymric",
            "The Cymric is a placid, sweet cat. They do not get too upset about anything that happens in their world. They are loving companions and adore people. They are smart and dexterous, capable of using his paws to get into cabinets or to open doors.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.Tpu0slQuS4mJbtI8jzWaKQHaEo%26pid%3DApi&f=1"
        ),
        Pet(
            "Selkirk Rex",
            "The Selkirk Rex is an incredibly patient, loving, and tolerant breed. The Selkirk also has a silly side and is sometimes described as clownish. She loves being a lap cat and will be happy to chat with you in a quiet voice if you talk to her.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.lm8gpCaTUKISuP8AU0xnTAHaFj%26pid%3DApi&f=1"
        ),
        Pet(
            "Munchkin",
            "The Munchkin is an outgoing cat who enjoys being handled. She has lots of energy and is faster and more agile than she looks. The shortness of their legs does not seem to interfere with their running and leaping abilities.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.ZtMqqTEzER-iigbSb5BmsAHaF7%26pid%3DApi&f=1"
        ),
        Pet(
            "Oriental",
            "Orientals are passionate about the people in their lives. They become extremely attached to their humans, so be prepared for a lifetime commitment. When you are not available to entertain her, an Oriental will divert herself by jumping on top of the refrigerator, opening drawers, seeking out new hideaways.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.kwkc_7Yosj69YWbWlDQ-oAHaEo%26pid%3DApi&f=1"
        ),
        Pet(
            "Turkish Van",
            "While the Turkish Van loves to jump and climb, play with toys, retrieve and play chase, she is is big and ungainly; this is one cat who doesn't always land on his feet. While not much of a lap cat, the Van will be happy to cuddle next to you and sleep in your bed.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.6gmQxnlZYFHl6IVHkNwqGAHaE7%26pid%3DApi&f=1"
        ),
        Pet(
            "York Chocolate",
            "York Chocolate cats are known to be true lap cats with a sweet temperament. They love to be cuddled and petted. Their curious nature makes them follow you all the time and participate in almost everything you do, even if it's related to water: unlike many other cats, York Chocolates love it.",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.R3IAG0Z7SAzTV56Xuvs1LwHaFj%26pid%3DApi&f=1"
        ),
    )

    val PET_MAP = HashMap<String, Pet>().also { map ->
        PET_LIST.map { pet ->
            map[pet.name] = pet
        }
    }
}
