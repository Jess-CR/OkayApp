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
import org.bedu.okayapp.databinding.ActivityProgressBinding
import org.bedu.okayapp.databinding.ActivityShowtemasBinding


class ShowTemas : AppCompatActivity(),OnTemaClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityShowtemasBinding
    private var listT = ArrayList<TemasDC>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowtemasBinding.inflate(layoutInflater)
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

        mTriviaViewModel.getCategories().observe(this, Observer {
                categories ->

            var uniqueCategories = categories.distinctBy { it.category}
            uniqueCategories.forEach { uniqueCategories ->
                var sum = 0f
                var prom = 0f
                var size = 0f

                categories.forEach {categories->
                    if(uniqueCategories.category == categories.category){
                        size +=1
                        sum += categories.ok!!
                    }

                }
                prom = (sum/size)*100

                listT.add(TemasDC(
                    uniqueCategories.category!!,
                    uniqueCategories.themeicon!!,
                    prom.toInt()))
            }
            var temaAdapter=Temas(listT,this)
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = temaAdapter
            temaAdapter.notifyDataSetChanged()

        })
        updateUI()
    }
    private fun updateUI(){
        val user = auth.currentUser
        if(user != null){
            binding.progreso2.text = user.email
            //binding.profileTxtViewUserName.text = user.displayName
        }
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
        intent.putExtra("theme",listT[position].title)

        startActivity(intent)
    }


}