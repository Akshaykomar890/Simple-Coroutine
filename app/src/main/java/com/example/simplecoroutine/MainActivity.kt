package com.example.simplecoroutine

import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.simplecoroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var count:Int =0
        binding.updateBtn.setOnClickListener {
            binding.updateTxt.text = (count+1).toString()
            count++
            Log.d(TAG,"${Thread.currentThread().name}")

        }

        binding.extraTask.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                for (i in 1..1000000000L)
                {

                }
            }
        }
    }
}