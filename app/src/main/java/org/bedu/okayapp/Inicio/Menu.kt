package org.bedu.okayapp.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import org.bedu.okayapp.R

class Menu : AppCompatActivity() {

    private lateinit var menu_img_logo: ImageView
    private lateinit var menu_btn_logIn: Button
    private lateinit var menu_btn_signUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        supportActionBar?.hide()

        menu_img_logo =findViewById(R.id.logoMenu)
        menu_btn_logIn =findViewById(R.id.menu_btn_logIn)
        menu_btn_signUp =findViewById(R.id.menu_btn_signUp)

        activity_logIn()
        activity_signUp()
    }
    fun activity_logIn(){
        menu_btn_logIn.setOnClickListener {
            val activity_logIn: Intent = Intent(this, LogIn::class.java)
            startActivity(activity_logIn)
        }
    }


    fun activity_signUp(){
        menu_btn_signUp.setOnClickListener {
            val activity_signUp: Intent = Intent(this, SignUp::class.java)
            startActivity(activity_signUp)
        }
    }


}