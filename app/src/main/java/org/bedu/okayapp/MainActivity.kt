package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var main_img_logo: ImageView
    private lateinit var main_img_apptitle: ImageView
    private lateinit var btnprueba: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_img_logo= findViewById(R.id.main_img_logo)
        main_img_apptitle= findViewById(R.id.main_img_apptitle)
        btnprueba= findViewById(R.id.btnprueba)

        btnprueba.setOnClickListener {
            val activity_menu: Intent = Intent(this,Menu::class.java )
            startActivity(activity_menu)
        }
    }
}