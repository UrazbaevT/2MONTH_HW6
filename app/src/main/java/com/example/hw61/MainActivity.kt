package com.example.hw61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.image_fragment, ImageFragment()).commit()

        supportFragmentManager.beginTransaction().add(R.id.songs_fragment, SongsFragment()).commit()
    }
}
