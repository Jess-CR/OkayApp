package org.bedu.okayapp.Trivia
//ketzalli
//muestra el video de youtube *se debe corregir
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubeStandalonePlayer
import org.bedu.okayapp.R

class Estudio : AppCompatActivity() {

    val API_KEY = "AIzaSyD6J7ssBgAaKyEORp7VceghPcm4u8Nh6ew"
    val videoPrueba="bgo9dJB_icw"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudio)

        val reproducir = findViewById<Button>(R.id.reproducir)

        reproducir.setOnClickListener {
            //comprueba internet
            val networkConnection = NetworkConnection(applicationContext)
            networkConnection.observe(this, Observer { isConnected ->
                if (isConnected) {
                    //ingresa a youtube
                    startActivity(YouTubeStandalonePlayer.createVideoIntent(this, API_KEY, videoPrueba))
                    //startActivity(Intent(this,Estudio::class.java))
                } else {
                    startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                }
            })
        }
    }
}