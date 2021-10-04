package org.bedu.okayapp.Trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories
import org.bedu.okayapp.databinding.ActivityIncorrectoBinding
import org.bedu.okayapp.databinding.ActivitySeleccionBinding

class Seleccion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySeleccionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.paraEstudio.setOnClickListener {
            val intent = Intent(this, Estudio::class.java)
            startActivity(intent)
        }

        binding.paraTest.setOnClickListener {
            val intent = Intent(this, BaseQuestion::class.java)
            startActivity(intent)
        }

    }
}