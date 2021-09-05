package Trivia
//ketzalli
//version de prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectobedufase3_prueba1.room.DatabaseTrivia
import com.example.proyectobedufase3_prueba1.room.SexualEducation
import com.example.proyectobedufase3_prueba2.R
import com.example.proyectobedufase3_prueba2.databinding.ActivityListBinding
import com.example.proyectobedufase3_prueba2.databinding.ActivityQuestionBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        this.supportActionBar?.hide()
        setContentView(view)

        //parte del recyclerview
        /*val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        var adapter: TriviaAdapter
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter*/
        //parte de la nueva
        binding.boton1.setOnClickListener {
            val intent = Intent(this, correcto::class.java)
            startActivity(intent)
        }
        binding.boton2.setOnClickListener {
            val intent = Intent(this, incorrecto::class.java)
            startActivity(intent)
        }
        binding.boton3.setOnClickListener {
            val intent = Intent(this, incorrecto::class.java)
            startActivity(intent)
        }

        //esto se pone en el oncreateview del fragment
        /*val executor:ExecutorService= Executors.newSingleThreadExecutor()
        executor.execute(Runnable{
            val preguntasArray=DatabaseTrivia
                .getInstance(requireContext())
                ?.triviaDao()
                ?.getSE() as MutableList<SexualEducation>

            *//*Handler(Looper.getMainLooper()).post(Runnable{
                adapter=TriviaAdapter(preguntasArray, getListener())
                recyclerView.adapter=adapter
            })*//*
        })*/
    }
}