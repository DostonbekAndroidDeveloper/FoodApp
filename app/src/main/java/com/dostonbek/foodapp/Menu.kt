package com.dostonbek.foodapp

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import com.dostonbek.foodapp.adapter.LvAdapter
import com.dostonbek.foodapp.databinding.ActivityMenuBinding
import com.dostonbek.foodapp.utils.MySharedPreference

class Menu : AddMeal() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: LvAdapter
    private lateinit var itemList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemList = MySharedPreference.userData!!
        adapter = LvAdapter(itemList, object : LvAdapter.OnItemClick {
            override fun onItemClick(userData: UserData, position: Int) {
                val intent = Intent(this@Menu, InfoActivity::class.java)
                intent.putExtra("food", userData)
                startActivity(intent)
            }
        })
        binding.listView.adapter = adapter

    }
}