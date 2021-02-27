package com.example.androiddevchallenge.model

data class Pet(
    val name: String,
    val description: String,
)

object Fixtures {
    val PET_LIST = listOf(
        Pet("Bengal", "Bengals are a lot of fun to live with, but they're definitely not the cat for everyone, or for first-time cat owners. Extremely intelligent, curious and active, they demand a lot of interaction and woe betide the owner who doesn't provide it."),
        Pet("Abyssinian", "The Abyssinian is easy to care for, and a joy to have in your home. They’re affectionate cats and love both people and other animals."),
        Pet("Cymric", "The Cymric is a placid, sweet cat. They do not get too upset about anything that happens in their world. They are loving companions and adore people. They are smart and dexterous, capable of using his paws to get into cabinets or to open doors."),
        Pet("Selkirk Rex", "The Selkirk Rex is an incredibly patient, loving, and tolerant breed. The Selkirk also has a silly side and is sometimes described as clownish. She loves being a lap cat and will be happy to chat with you in a quiet voice if you talk to her."),
        Pet("Munchkin", "The Munchkin is an outgoing cat who enjoys being handled. She has lots of energy and is faster and more agile than she looks. The shortness of their legs does not seem to interfere with their running and leaping abilities."),
        Pet("Oriental", "Orientals are passionate about the people in their lives. They become extremely attached to their humans, so be prepared for a lifetime commitment. When you are not available to entertain her, an Oriental will divert herself by jumping on top of the refrigerator, opening drawers, seeking out new hideaways."),
        Pet("Turkish Van", "While the Turkish Van loves to jump and climb, play with toys, retrieve and play chase, she is is big and ungainly; this is one cat who doesn't always land on his feet. While not much of a lap cat, the Van will be happy to cuddle next to you and sleep in your bed."),
        Pet("York Chocolate", "York Chocolate cats are known to be true lap cats with a sweet temperament. They love to be cuddled and petted. Their curious nature makes them follow you all the time and participate in almost everything you do, even if it's related to water: unlike many other cats, York Chocolates love it."),
    )
}
