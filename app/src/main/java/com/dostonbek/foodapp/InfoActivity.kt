package com.dostonbek.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dostonbek.foodapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getParcelableExtra<UserData>("food")!! as UserData

        binding.title.text = food.title
        binding.kerakli.text = food.productOfMeal
        binding.tartib.text = food.dailyOfMakingMeal
    }
}