package com.example.definitiva

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.definitiva.databinding.ActivityThirdBinding

class ThirdActivity : Activity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegresarActividad2.setOnClickListener {
            finish()
        }

        binding.btnRegresarInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}