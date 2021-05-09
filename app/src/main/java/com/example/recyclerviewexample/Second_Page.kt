package com.example.recyclerviewexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class Second_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second__page)
        setTitle("Detailed Information")
        val bundle = intent.extras
        val name = bundle?.getString("data")
        val T:TextView =  findViewById(R.id.showName)
        val P:ImageView = findViewById(R.id.Photo1)
        T.text = name.toString()
        val drawableResource = when(T.text){
            "Basketball" -> R.drawable.basketball_photo
            "Football" -> R.drawable.football_photo
            "Other" -> R.drawable.other_photo
            else -> R.drawable.baseball_photo
        }

        P.setImageResource(drawableResource)

    }


}