package org.bedu.okayapp.Trivia
//ketzalli
//permite escoger si ir al test o si ir a la zona de estudio (youtube)
//se debe cambiar para mostrar el contenido en base al tema escogido
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.bedu.okayapp.R
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