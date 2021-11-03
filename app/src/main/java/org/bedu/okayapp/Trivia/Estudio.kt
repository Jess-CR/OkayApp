package org.bedu.okayapp.Trivia
//ketzalli
//muestra el video de youtube *se debe corregir
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import org.bedu.okayapp.R
import java.util.regex.Pattern

class Estudio : YouTubeBaseActivity() {

    val API_KEY = "AIzaSyD6J7ssBgAaKyEORp7VceghPcm4u8Nh6ew"
    val videoPrueba="bgo9dJB_icw"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudio)
        var youtubePlayer = findViewById<YouTubePlayerView>(R.id.youtubePlayer)
        val reproducir = findViewById<Button>(R.id.reproducir)
        var youtubePlayerInit:YouTubePlayer.OnInitializedListener
        youtubePlayerInit=object:YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(videoPrueba)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext,"Errorrrrrrr",Toast.LENGTH_SHORT).show()
            }

        }
        reproducir.setOnClickListener{
            youtubePlayer.initialize(API_KEY,youtubePlayerInit)
        }
    }
}