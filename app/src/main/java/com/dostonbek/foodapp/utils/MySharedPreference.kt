package com.dostonbek.foodapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.dostonbek.foodapp.UserData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME:String="taom"
    private const val MODE:Int=Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences=context.getSharedPreferences(NAME, MODE)
    }
    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor)-> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }
    var userData:ArrayList<UserData>?
    get() = stringToArray(preferences.getString("taom","[]")!!)
    set(value) = preferences.edit(){data->
        if (value != null){
            data.putString("taom", arrayToString(value))
        }

    }
    private fun arrayToString(list: ArrayList<UserData>):String {
        return Gson().toJson(list)
    }
    private fun  stringToArray(list: String):ArrayList<UserData>{
        val type =object :TypeToken<List<UserData>>() {}.type
        return Gson().fromJson(list,type)
    }



}