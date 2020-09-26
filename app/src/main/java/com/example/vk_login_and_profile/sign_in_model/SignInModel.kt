package com.example.vk_login_and_profile.sign_in_model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignInModel(var email: String = "", var password: String = "") : Parcelable {

    @IgnoredOnParcel
    private val originEmail = "dpflint@yandex.ru"

    @IgnoredOnParcel
    private val originPassword = "000451000"

    fun checkEmailAndPassword(): Boolean {
        return email == originEmail && password == originPassword
    }

}