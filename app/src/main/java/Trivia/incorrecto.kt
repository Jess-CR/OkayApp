package Trivia
//ketzalli
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectobedufase3_prueba2.databinding.ActivityCorrectoBinding
import com.example.proyectobedufase3_prueba2.databinding.ActivityIncorrectoBinding

class incorrecto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIncorrectoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.continuar.setOnClickListener {
            val intent = Intent(this, resultado::class.java)
            startActivity(intent)
        }
    }
}