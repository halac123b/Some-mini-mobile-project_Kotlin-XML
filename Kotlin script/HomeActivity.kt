package com.halac123b.xml_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val foodGyoza = findViewById<LinearLayout>(R.id.foodGyoza)
        foodGyoza.setOnClickListener({
            val foodDetails = Intent(this, FoodDetail::class.java)
            startActivity(foodDetails);
        })
    }
}