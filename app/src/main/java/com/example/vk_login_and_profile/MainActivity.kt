package com.example.vk_login_and_profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vk_login_and_profile.sign_in_model.SignInModel
import kotlinx.android.synthetic.main.activity_main.*
import maes.tech.intentanim.CustomIntent

class MainActivity : AppCompatActivity() {

    private var signInModel: SignInModel = SignInModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vk_edit_text_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                signInModel.email = vk_edit_text_email.text.toString().trim()

                vk_sign_in_button.isEnabled = isValidSim()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        vk_edit_text_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                signInModel.password = vk_edit_text_password.text.toString().trim()

                vk_sign_in_button.isEnabled = isValidSim()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        vk_sign_in_button.setOnClickListener {
            if (signInModel.checkEmailAndPassword()) {
                startActivity(ProfileActivity.getNewInstance(this, signInModel))
                CustomIntent.customType(this, "fadein-to-fadeout")
            } else {
                Toast.makeText(this, "Email or password are incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isValidSim(): Boolean {
        return EMAIL_ADDRESS.matcher(signInModel.email)
            .matches() && (signInModel.password.length >= 8)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getParcelable<SignInModel>("sign_in_model")
        Log.d("myLog", "${signInModel.email} ${signInModel.password}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putParcelable("sign_in_model", signInModel)
    }
}