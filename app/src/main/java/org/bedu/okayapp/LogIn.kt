package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogIn : AppCompatActivity() {
    private lateinit var sign_up_btn_logIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        sign_up_btn_logIn= findViewById(R.id.sign_up_btn_logIn)

        activity_logIn()
        /*DEBUG ALOPEZ
        val intent = Intent(this, Progress::class.java)
        startActivity(intent)*/
    }

    fun activity_logIn(){
        sign_up_btn_logIn.setOnClickListener {
            val ventanacategorias: Intent = Intent(this, categories::class.java)
            startActivity(ventanacategorias)
        }
    }

}
