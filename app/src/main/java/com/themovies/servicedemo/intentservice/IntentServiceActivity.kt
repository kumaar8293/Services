package com.themovies.servicedemo.intentservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.themovies.servicedemo.databinding.IntentServiceactivityMainBinding

class IntentServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = IntentServiceactivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvServiceStatus.text = "Service running..."
            }
        }

        binding.btnStop.setOnClickListener {
            //We can also save above intent in a variable and stop like below
            // stopService(pass ur intent)

            MyIntentService.stopService()
            binding.tvServiceStatus.text = "Service stopped"
        }
    }
}