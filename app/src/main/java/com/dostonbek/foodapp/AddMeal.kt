package com.dostonbek.foodapp

import android.annotation.SuppressLint
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView
import com.dostonbek.foodapp.R.*
import com.dostonbek.foodapp.adapter.LvAdapter
import com.dostonbek.foodapp.databinding.ActivityAddMealBinding
import com.dostonbek.foodapp.utils.MySharedPreference


open class AddMeal : AppCompatActivity() {
    val position: Int
        get() {
            TODO()
        }
    private lateinit var binding: ActivityAddMealBinding

    private lateinit var adapter: LvAdapter
    private lateinit var itemList: ArrayList<UserData>

    @SuppressLint("CommitPrefEdits", "SuspiciousIndentation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreference.init(this)

        itemList = ArrayList()
        binding.save.setOnClickListener {
            val title: String = binding.title.text.toString()
            val productOfMeal: String = binding.productOfMeal.text.toString()
            val dailyOfMakingMeal: String = binding.dailyOfMakingMeal.text.toString()

            val taom = UserData(title, productOfMeal, dailyOfMakingMeal)
            val itemList = MySharedPreference.userData

            itemList?.add(taom)
            MySharedPreference.userData = itemList
            finish()
        }
    }
}