package org.bedu.okayapp.Temas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Animations.ProgressBarAnimation
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.Trivia.QuestionFragment.Companion.mTriviaViewModel
import org.bedu.okayapp.databinding.ActivityShowtemasBinding


class ShowTemas : AppCompatActivity(),OnTemaClickListener {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShowtemasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()
        val progressBar = ProgressBarAnimation(
            binding.CategoriesProgressBar,
            binding.progressPercentage,
            binding.progressPercentage
        )
        mTriviaViewModel.getTotalProgress().observe(this, Observer {
            avg ->   progressBar.initProgressBar(avg)

        })

        binding.categoriasButtonSalir.setOnClickListener {
            signOut()
        }

        /*mTriviaViewModel.getCategories().observe(this, Observer {
            categories ->
            var listT = ArrayList<TemasDC>()
            categories.forEach {
                listT.add(TemasDC(it,R.drawable.temas_1,12))
            }

ALOPEZ se debe generar el query similar a SubTemas para generar lista que alimenta recicler view y porcetaje de avance
        })*/
        var temaAdapter=Temas(generateDataT(),this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = temaAdapter

        temaAdapter.notifyDataSetChanged()

    }

    private fun generateDataT(): ArrayList<TemasDC> {
        var listT = ArrayList<TemasDC>()

        listT.add(
            TemasDC("Salud Sexual", "https://i.imgur.com/urgYhKC.png", 0)
        )
        listT.add(
            TemasDC("Finanzas", "https://i.imgur.com/GKyEkwY.png", 0)
        )
        listT.add(
            TemasDC("Vida Laboral", "https://i.imgur.com/SSXdMgw.png", 0)
        )
        listT.add(
            TemasDC("Medio Ambiente","https://i.imgur.com/rOY6O5g.png", 0)
        )
        listT.add(
            TemasDC("Salud", "https://i.imgur.com/skolR9G.png", 0)
        )
        //listT.add(
         //   TemasDC("Relaciones humanas", R.drawable.temas_6, 0)
        //)
        return listT
    }

    fun progreso(view: View) {
        startActivity(Intent(this, Progress::class.java))

    }

    private fun signOut() {
        Firebase.auth.signOut()
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }

    override fun onTemaItemClicked(position: Int) {
        val intent = Intent(this, ShowSubTemas::class.java)
        intent.putExtra("theme",generateDataT()[position].title)

        startActivity(intent)
    }
}