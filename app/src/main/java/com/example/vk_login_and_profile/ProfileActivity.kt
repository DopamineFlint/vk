package com.example.vk_login_and_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import maes.tech.intentanim.CustomIntent

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "fadein-to-fadeout")
    }
}