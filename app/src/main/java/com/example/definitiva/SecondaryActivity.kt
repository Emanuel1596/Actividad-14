package com.example.definitiva

import android.app.Activity
import android.os.Build
import android.os.Bundle
import com.example.definitiva.databinding.ActivitySecondaryBinding

class SecondaryActivity : Activity() {

    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreUsuario = intent.getStringExtra(MainActivity.EXTRA_USER_NAME) ?: "Sin nombre"
        val edad = intent.getIntExtra(MainActivity.EXTRA_EDAD, 0)
        val esEstudiante = intent.getBooleanExtra(MainActivity.EXTRA_ES_ESTUDIANTE, false)

        val heroe = obtenerHeroe()

        binding.tvNombreUsuario.text = "Nombre recibido: $nombreUsuario"
        binding.tvEdad.text = "Edad: $edad"
        binding.tvEsEstudiante.text = "¿Es estudiante?: ${if (esEstudiante) "Sí" else "No"}"

        binding.tvHeroe.text = if (heroe != null) {
            """
            Héroe recibido:
            Nombre: ${heroe.nombre}
            Nivel: ${heroe.nivel}
            Vida: ${heroe.vida}
            """.trimIndent()
        } else {
            "No se recibió ningún héroe."
        }

        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun obtenerHeroe(): Heroe? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_HEROE, Heroe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(MainActivity.EXTRA_HEROE)
        }
    }
}