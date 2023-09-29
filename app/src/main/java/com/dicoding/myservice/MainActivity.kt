package com.dicoding.myservice

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.myservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this@MainActivity, MyBackgroundService::class.java)
        binding.btnStartBackgroundService.setOnClickListener {
            startService(serviceIntent)
        }
        binding.btnStopBackgroundService.setOnClickListener {
            stopService(serviceIntent)
        }

        val foregroundServiceIntent = Intent(this@MainActivity, MyForegroundService::class.java)
        binding.btnStartForegroundService.setOnClickListener {
            if(Build.VERSION.SDK_INT >= 26){
                startForegroundService(foregroundServiceIntent)
            }else{
                startService(foregroundServiceIntent)
            }
        }
        binding.btnStopForegroundService.setOnClickListener {
            stopService(foregroundServiceIntent)
        }
    }
}