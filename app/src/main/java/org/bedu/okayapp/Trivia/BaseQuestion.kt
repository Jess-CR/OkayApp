package org.bedu.okayapp.Trivia
//ketzalli
//contiene el fragment de las preguntas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.R

class BaseQuestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_question)
        supportActionBar?.hide()
    }
}