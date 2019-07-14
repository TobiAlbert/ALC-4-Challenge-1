package com.example.alc4androidchallenge1.modules.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alc4androidchallenge1.R
import com.example.alc4androidchallenge1.shared.models.Track.*
import com.example.alc4androidchallenge1.shared.models.User
import kotlinx.android.synthetic.main.activity_my_profile.*
import kotlinx.android.synthetic.main.toolbar.*

class MyProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        setupUI()
    }

    private fun setupUI() {
        // setup toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.my_profile_text)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // load hard-coded dummy user data
        val user = User(
            "Tobi Daada",
            "+2348060868331",
            "daadatobi@gmail.com",
            "Nigeria",
            ANDROID,
            "@Tobi"
        )

        // setup text views
        usernameTxt.text = user.username

        val track = when (user.track) {
            ANDROID -> "Android"
            MOBILE_WEB -> "Mobile Web"
            GOOGLE_CLOUD -> "Google Cloud"
        }

        trackTxt.text = getString(R.string.title_track, track)
        countryTxt.text = getString(R.string.title_country, user.country)
        emailTxt.text = getString(R.string.title_email, user.email)
        phoneTxt.text = getString(R.string.title_phone_number, user.phoneNumber)
        slackTxt.text = getString(R.string.title_slack_username, user.slackHandle)
    }
}
