package com.themovies.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.themovies.servicedemo.databinding.ActivityHomeBinding
import com.themovies.servicedemo.forgroundservice.ForgroundServiceActivity
import com.themovies.servicedemo.intentservice.IntentServiceActivity
import com.themovies.servicedemo.service.ServiceActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIntentService.setOnClickListener {
            Intent(this, IntentServiceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnService.setOnClickListener {
            Intent(this, ServiceActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.btnForgroundService.setOnClickListener {
            Intent(this, ForgroundServiceActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnNotification.setOnClickListener {
            Intent(this, NotificationActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}