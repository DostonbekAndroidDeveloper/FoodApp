package com.dostonbek.foodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dostonbek.foodapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val getTaom=intent?.extras.getSerializable("class",UserData::class.java)
        binding.addMeal.setOnClickListener {
            startActivity(Intent(this,AddMeal::class.java))
        }
        binding.menu.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))


        }
    }
}