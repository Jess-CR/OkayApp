package org.bedu.okayapp

import Animations.ProgressBarAnimation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import org.bedu.okayapp.databinding.ActivityCategoriesBinding


class categories : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var binding: ActivityCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
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


    }

    fun progreso(view: View) {
        startActivity(Intent(this, Progress::class.java))
    }
}