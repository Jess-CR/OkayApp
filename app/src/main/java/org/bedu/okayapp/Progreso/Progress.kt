package org.bedu.okayapp.Progreso

import android.content.Context
import org.bedu.okayapp.Animations.ProgressBarAnimation
import org.bedu.okayapp.Trivia.BaseQuestion
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Inicio.Profile
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityProgressBinding

class Progress : AppCompatActivity() {
    companion object{
        val PREFS_NAME = "org.bedu.OkayApp"
        val BADGE_1 = "Badge_1"

    }
    lateinit var preferences: SharedPreferences
    private lateinit var binding: ActivityProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar = ProgressBarAnimation(
            binding.progressPogressBar,
            binding.progressPogressStatus,
            binding.progressTextPercentage,
        )
         preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) //Modo privado


        progressBar.initProgressBar()

        val badge = preferences.getBoolean(BADGE_1,false)
        if (badge){
            binding.badge1.setImageResource(R.drawable.sexual_education)
        }

        //ketzalli -> solo le agregue la acción al boton
        binding.progressBtnPlay.setOnClickListener {
            val intent = Intent(this, BaseQuestion::class.java)
            startActivity(intent)
        }
        //hasta aqui

        activity_profile()
    }

    //Jessica --> con esto se liga a la pantalla de profile
    fun activity_profile(){
        binding.progressBtnProfile.setOnClickListener {
            val ventanaProfile: Intent = Intent(this, Profile::class.java)
            startActivity(ventanaProfile)
            }
    }

}

