package com.dostonbek.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.dostonbek.foodapp.UserData
import com.dostonbek.foodapp.databinding.ItemBinding

class LvAdapter(private var userData: List<UserData>, var onItemClick: OnItemClick) : BaseAdapter() {
    override fun getCount(): Int = userData.size


    override fun getItem(position: Int): UserData = userData[position]

    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        binding.tv.text = userData[position].title

        binding.root.setOnClickListener{
            onItemClick.onItemClick(userData[position], position)
        }

      return  binding.root
    }
    interface OnItemClick {
        fun onItemClick(userData: UserData, position: Int)
    }
}