package com.example.definitiva

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.definitiva.databinding.ActivitySecondaryBinding

class SecondaryActivity : Activity() {

    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAbrirTercera.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnVolverMain.setOnClickListener {
            finish()
        }
    }
}