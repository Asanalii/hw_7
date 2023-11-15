//package com.example.life_cycle_view
//
//import android.os.Bundle
//import android.os.PersistableBundle
//import androidx.appcompat.app.AppCompatActivity
//import com.example.life_cycle_view.databinding.ActivitySecondBinding
//
//class SecondActivity:AppCompatActivity() {
//
//    private lateinit var binding: ActivitySecondBinding
//
//
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        binding = ActivitySecondBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.toolbar.backClick = {
//            finish()
//        }
//    }
//}