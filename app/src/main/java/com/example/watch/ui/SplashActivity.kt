package com.example.watch.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.watch.R
import java.lang.Exception

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashTime = object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(1500)
                } catch (e: Exception) {

                } finally {
                    startActivity(Intent(this@SplashActivity, HostHomeActivity::class.java))
                    Animatoo.animateZoom(this@SplashActivity)
                    finish()
                }
            }
        }
        splashTime.start()
    }
}