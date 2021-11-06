package org.bedu.okayapp.Temas

import android.content.ContentValues.TAG
import org.bedu.okayapp.Animations.ProgressBarAnimation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.R
import org.bedu.okayapp.Trivia.QuestionFragment
import org.bedu.okayapp.Trivia.QuestionFragment.Companion.mTriviaViewModel
import org.bedu.okayapp.Trivia.Seleccion
import org.bedu.okayapp.databinding.ActivityShowtemasBinding


class ShowTemas : AppCompatActivity(),OnTemaClickListener {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShowtemasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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


        })*/
        var temaAdapter=Temas(generateDataT(),this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = temaAdapter

        temaAdapter.notifyDataSetChanged()

    }

    private fun generateDataT(): ArrayList<TemasDC> {
        var listT = ArrayList<TemasDC>()

        listT.add(
            TemasDC("Salud Sexual", R.drawable.temas_1, 12)
        )
        listT.add(
            TemasDC("Finanzas", R.drawable.temas_2, 50)
        )
        listT.add(
            TemasDC("Vida laboral", R.drawable.temas_3, 90)
        )
        listT.add(
            TemasDC("Medio ambiente", R.drawable.temas_4, 30)
        )
        listT.add(
            TemasDC("Salud", R.drawable.temas_5, 10)
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