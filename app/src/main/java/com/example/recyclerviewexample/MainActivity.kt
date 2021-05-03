package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //data source
    private val ballList = ArrayList<Balls>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setup our initial data
        initBallList()
        //configure the recyclerview
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = BallAdapter(ballList) //pass by reference
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        //add a divider line

    }

    private fun initBallList() {
        repeat(6) {
            ballList.add(Balls("Baseball", R.drawable.baseball))
            ballList.add(Balls("Basketball", R.drawable.basketball))
            ballList.add(Balls("Football", R.drawable.football))
            ballList.add(Balls("Other", R.drawable.other))
        }
    }
}