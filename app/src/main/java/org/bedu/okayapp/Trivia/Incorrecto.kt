package org.bedu.okayapp.Trivia
//ketzalli
//se muestra cuando hubo respuestas incorrectas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.Temas.ShowTemas
import org.bedu.okayapp.databinding.ActivityIncorrectoBinding

class Incorrecto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIncorrectoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed({
            val intent = Intent(this, ShowTemas::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}