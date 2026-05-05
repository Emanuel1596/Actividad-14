package com.example.definitiva

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.definitiva.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_USER_NAME = "USER_NAME"
        const val EXTRA_EDAD = "EDAD"
        const val EXTRA_ES_ESTUDIANTE = "ES_ESTUDIANTE"
        const val EXTRA_HEROE = "HEROE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            val nombreEscrito = binding.etNombre.text.toString().trim()

            val nombreFinal = if (nombreEscrito.isEmpty()) {
                "Usuario sin nombre"
            } else {
                nombreEscrito
            }

            val bundle = Bundle()
            bundle.putInt(EXTRA_EDAD, 20)
            bundle.putBoolean(EXTRA_ES_ESTUDIANTE, true)

            val heroe = Heroe(
                nombre = "Caballero Android",
                nivel = 10,
                vida = 100
            )

            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra(EXTRA_USER_NAME, nombreFinal)
            intent.putExtras(bundle)
            intent.putExtra(EXTRA_HEROE, heroe)

            startActivity(intent)
        }
    }
}