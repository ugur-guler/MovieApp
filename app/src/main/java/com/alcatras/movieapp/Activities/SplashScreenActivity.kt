package com.alcatras.movieapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.alcatras.movieapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        Handler().postDelayed({
          val intent= Intent(this@SplashScreenActivity, AccountOperationsActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}