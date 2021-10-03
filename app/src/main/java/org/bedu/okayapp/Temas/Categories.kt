package org.bedu.okayapp.Temas

import org.bedu.okayapp.Animations.ProgressBarAnimation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityCategoriesBinding
import kotlin.math.sign


class categories : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var binding: ActivityCategoriesBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        auth=FirebaseAuth.getInstance()
        setContentView(binding.root)
        val arrayAdapter: ArrayAdapter<*>
        val servicio1 = resources.getStringArray(R.array.Categorias)
        listaCategorias = findViewById(R.id.listaCategorias)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, servicio1)
        listaCategorias.adapter = arrayAdapter

        listaCategorias.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, Topic::class.java)
                startActivity(intent)
            }

        val progressBar = ProgressBarAnimation(binding.CategoriesProgressBar,binding.progressPercentage,binding.progressPercentage)

        progressBar.initProgressBar()

        binding.categoriasButtonSalir.setOnClickListener {
            signOut()
        }
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