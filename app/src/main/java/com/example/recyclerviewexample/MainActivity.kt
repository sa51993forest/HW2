package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //data source
    private val ballList = ArrayList<Balls>()
    //private val photoList = ArrayList<Photos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("List of Sports")
        //setup our initial data
        initBallList()
        //configure the recyclerview
        val layoutManager = LinearLayoutManager(this)
        //val layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = BallAdapter(ballList) //pass by reference
        binding.recyclerview.adapter = adapter
        adapter.setToEditCLickListener(object : BallAdapter.ItemCLickListener{
            override fun toEdit(Name:String){
                EditEvent(Name)
            }
        })
        binding.recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }

    private fun initBallList() {
            ballList.add(Balls("Baseball", R.drawable.baseball))
            ballList.add(Balls("Basketball", R.drawable.basketball))
            ballList.add(Balls("Football", R.drawable.football))
            ballList.add(Balls("Other", R.drawable.other))
    }
    fun EditEvent(Name:String){
        val intent = Intent(this,Second_Page::class.java).apply{
            putExtra("data",Name)
        }

        startActivity(intent)
    }
}