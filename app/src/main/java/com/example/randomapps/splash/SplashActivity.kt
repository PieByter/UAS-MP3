package com.example.randomapps.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.randomapps.MainActivity
import com.example.randomapps.R

@Suppress("DEPRECATION")

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DURATION: Long = 1000 // misalnya, 2 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Navigasi ke activity utama atau activity berikutnya
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DURATION)
    }
}
