package com.dostonbek.foodapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserData(var title: String, var productOfMeal: String, var dailyOfMakingMeal: String) :
    Parcelable
