package org.bedu.okayapp.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories

class LogIn : AppCompatActivity() {
    private lateinit var log_in_btn_logIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        log_in_btn_logIn =findViewById(R.id.log_in_btn_logIn)

        activity_logIn()
        /*DEBUG ALOPEZ
        val intent = Intent(this, Progress::class.java)
        startActivity(intent)*/
    }

    fun activity_logIn(){
        log_in_btn_logIn.setOnClickListener {
            val ventanacategorias: Intent = Intent(this, categories::class.java)
            startActivity(ventanacategorias)
        }
    }

}
