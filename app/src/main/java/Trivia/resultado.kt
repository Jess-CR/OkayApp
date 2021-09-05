package Trivia
//ketzalli
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectobedufase3_prueba2.MainActivity
import com.example.proyectobedufase3_prueba2.databinding.ActivityMainBinding
import com.example.proyectobedufase3_prueba2.databinding.ActivityResultadoBinding

class resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.continuar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}