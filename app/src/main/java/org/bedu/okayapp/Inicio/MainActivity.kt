package org.bedu.okayapp.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.bedu.okayapp.R

class MainActivity : AppCompatActivity() {

    /*private lateinit var main_img_logo: ImageView
    private lateinit var main_img_apptitle: ImageView
    private lateinit var btnprueba: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Para mejorar apariencia quitando la barra de arriba
        supportActionBar?.hide()

        //Agregar Handler para que automáticamente después de 2.5 seg pase a la act. Menu
      Handler().postDelayed({
          val intent = Intent(this@MainActivity, Menu::class.java)
          startActivity(intent)
          finish()
      }, 3500)


        //Comento esta parte para cargar el intro a partir del svg

        /*main_img_logo= findViewById(R.id.main_img_logo)
        main_img_apptitle= findViewById(R.id.main_img_apptitle)
        btnprueba= findViewById(R.id.btnprueba)*/

        /*btnprueba.setOnClickListener {
            val activity_menu: Intent = Intent(this,Menu::class.java )
            startActivity(activity_menu)
        }*/
    }
}