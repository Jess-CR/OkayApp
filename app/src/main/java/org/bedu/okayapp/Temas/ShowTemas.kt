package org.bedu.okayapp.Temas

import org.bedu.okayapp.Animations.ProgressBarAnimation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityShowtemasBinding


class ShowTemas : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityShowtemasBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()
        val progressBar = ProgressBarAnimation(binding.CategoriesProgressBar,binding.progressPercentage,binding.progressPercentage)
        progressBar.initProgressBar()
        binding.categoriasButtonSalir.setOnClickListener {
            signOut()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = Temas(generateDataT())
        binding.recyclerView.setOnClickListener{
            startActivity(Intent(this,ShowSubTemas::class.java))
        }
    }

    private fun generateDataT():ArrayList<TemasDC>{
        var listT=ArrayList<TemasDC>()
        listT.add(
            TemasDC("Salud sexual y reproductiva",R.drawable.imgprueba,20)
        )
        listT.add(
            TemasDC("Finanzas",R.drawable.imgprueba,50)
        )
        listT.add(
            TemasDC("Vida laboral",R.drawable.imgprueba,90)
        )
        listT.add(
            TemasDC("Medio ambiente",R.drawable.imgprueba,30)
        )
        listT.add(
            TemasDC("Salud",R.drawable.imgprueba,10)
        )
        listT.add(
            TemasDC("Relaciones humanas",R.drawable.imgprueba,0)
        )
        return listT
    }

    fun progreso(view: View) {
        startActivity(Intent(this, Progress::class.java))
    }

    private fun signOut(){
        Firebase.auth.signOut()
        val intent = Intent(this,LogIn::class.java)
        startActivity(intent)
    }
}