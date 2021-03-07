package com.themovies.servicedemo.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.themovies.servicedemo.databinding.ActivityServiceBinding
import com.themovies.servicedemo.intentservice.MyIntentService

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                binding.tvServiceStatus.text = "Service running..."
            }
        }

        binding.btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
            }
            binding.tvServiceStatus.text = "Service stopped"
        }


        binding.btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                it.putExtra("EXTRA_DATA", binding.editData.text.toString())
                startService(it)
                binding.tvServiceStatus.text = "Service running..."
            }
        }
    }
}