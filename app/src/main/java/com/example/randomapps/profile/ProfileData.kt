package com.example.randomapps.profile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileData(val name: String, val nim: String, val photoResId: Int) : Parcelable


