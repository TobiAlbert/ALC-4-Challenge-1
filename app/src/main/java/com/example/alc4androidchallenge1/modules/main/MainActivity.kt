package com.example.alc4androidchallenge1.modules.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alc4androidchallenge1.R
import com.example.alc4androidchallenge1.modules.about.AboutAlcActivity
import com.example.alc4androidchallenge1.modules.profile.MyProfileActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        // setup toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        // setup click listeners
        aboutAlcBtn.setOnClickListener { openActivity<AboutAlcActivity>() }
        myProfileBtn.setOnClickListener { openActivity<MyProfileActivity>() }
    }

    private inline fun <reified T> openActivity() { startActivity(Intent(this, T::class.java)) }
}
