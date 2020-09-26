package com.example.vk_login_and_profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.vk_login_and_profile.sign_in_model.SignInModel
import kotlinx.android.synthetic.main.activity_profile.*
import maes.tech.intentanim.CustomIntent

class ProfileActivity : AppCompatActivity() {

    companion object {

        private const val SIGN_IN_KEY = "asd4a688wq65as5d"

        fun getNewInstance(context: Context, signInModel: SignInModel): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(SIGN_IN_KEY, signInModel)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val arguments: Bundle? = intent.extras!!
        Log.d("My Log", "$arguments")
        val signInModel: SignInModel =
            arguments!!.getParcelable(SIGN_IN_KEY)!!
        Log.d("My Log", "$signInModel")
        vk_profile_toolbar.title = signInModel.email
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "fadein-to-fadeout")
    }
}