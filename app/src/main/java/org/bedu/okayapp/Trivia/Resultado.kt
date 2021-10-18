package org.bedu.okayapp.Trivia
//ketzalli
//si todas las respuestas fueron correctas se otorga una insignia
//la insignia no esta implementada

import org.bedu.okayapp.Temas.ShowTemas
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.continuar.setOnClickListener {
            val intent = Intent(this, ShowTemas::class.java)
            startActivity(intent)
        }
    }
}