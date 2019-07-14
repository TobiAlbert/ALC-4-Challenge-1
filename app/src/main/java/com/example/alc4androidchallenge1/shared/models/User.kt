package com.example.alc4androidchallenge1.shared.models

data class User (
    val username: String,
    val phoneNumber: String,
    val email: String,
    val country: String,
    val track: Track,
    val slackHandle: String
)

enum class Track {
    ANDROID, MOBILE_WEB, GOOGLE_CLOUD
}