package org.bedu.okayapp.Progreso

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import org.bedu.okayapp.Animations.ProgressBarAnimation
import org.bedu.okayapp.Inicio.Profile
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.ShowTemas
import org.bedu.okayapp.Trivia.QuestionFragment.Companion.mTriviaViewModel
import org.bedu.okayapp.databinding.ActivityProgressBinding

class Progress : AppCompatActivity() {
    companion object{
        val PREFS_NAME = "org.bedu.OkayApp"
        val BADGE_1 = "Badge_1"

    }
    lateinit var preferences: SharedPreferences
    private lateinit var binding: ActivityProgressBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        auth= FirebaseAuth.getInstance()
        supportActionBar?.hide()

        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar = ProgressBarAnimation(
            binding.progressPogressBar,
            binding.progressPogressStatus,
            binding.progressTextPercentage,
        )
         preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) //Modo privado



        mTriviaViewModel.getTotalProgress().observe(this, Observer { avg->
          progressBar.initProgressBar(avg)
        })


        val badge = preferences.getBoolean(BADGE_1,false)
        if (badge){
            binding.badge1.setImageResource(R.drawable.sexual_education)
        }

        //ketzalli -> solo le agregue la acción al boton
        binding.progressBtnPlay.setOnClickListener {
            val intent = Intent(this, ShowTemas::class.java)
            intent.putExtra("temaP","ETS")
            startActivity(intent)
        }
        //hasta aqui
        updateUI()
        activity_profile()
    }

    //Jessica --> con esto se liga a la pantalla de profile
    fun activity_profile(){
        binding.progressBtnProfile.setOnClickListener {
            val ventanaProfile: Intent = Intent(this, Profile::class.java)
            startActivity(ventanaProfile)
            }
    }

    private fun updateUI(){
        val user = auth.currentUser
        if(user != null){
            binding.progressTextGreett.text = user.email
            //binding.profileTxtViewUserName.text = user.displayName
        }
    }
}

