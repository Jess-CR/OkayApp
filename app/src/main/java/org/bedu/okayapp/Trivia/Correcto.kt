package org.bedu.okayapp.Trivia
//ketzalli
//se muestra cuando todas las respuestas fueron correctas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.databinding.ActivityCorrectoBinding

class Correcto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCorrectoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed({
            val intent = Intent(this, Resultado::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}