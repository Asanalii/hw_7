package com.example.life_cycle_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.life_cycle_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.toolbar.title = "Hello world"
//        binding.toolbar.showFavoriteButton = false

//        binding.toolbar.favoriteClick = {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

//        binding.toolbar.title.text = "New toolbar title"
//        binding.toolbar.favoriteButton.isVisible = true
    }
}