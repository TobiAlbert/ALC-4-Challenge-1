package com.example.alc4androidchallenge1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        // setup click listeners
        aboutAlcBtn.setOnClickListener { openActivity(AboutAlcActivity::class.java) }
        myProfileBtn.setOnClickListener { openActivity(MyProfileActivity::class.java) }
    }

    private fun openActivity(activity: Class<*>) { startActivity(Intent(this, activity)) }
}
