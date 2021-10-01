package org.bedu.okayapp.Trivia
//ketzalli
//se muestra cuando todas las respuestas fueron correctas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.databinding.ActivityCorrectoBinding

class Correcto : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        preferences = getSharedPreferences(Progress.PREFS_NAME, Context.MODE_PRIVATE) //Modo privado
        super.onCreate(savedInstanceState)
        val binding = ActivityCorrectoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





       saveData()
        Handler().postDelayed({
            val intent = Intent(this, Resultado::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
    fun saveData(){

        preferences.edit()
            .putBoolean(Progress.BADGE_1,true)
            .apply() //a diferencia de commit, apply hace los cambios en el momento, pausando el Thread
    }

}
