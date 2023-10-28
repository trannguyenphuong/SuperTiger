package com.supergame.supertiger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.supergame.supertiger.databinding.ActivityMainSplashBinding

class MainSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.raw.progress).into(binding.imvProgress)
        Glide.with(this).load(R.raw.logo).into(binding.imvLogo)

        binding.imvProgress.postDelayed({
            val intent = Intent(this, GameDetailActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}