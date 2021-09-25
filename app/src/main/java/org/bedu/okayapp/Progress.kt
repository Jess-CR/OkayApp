package org.bedu.okayapp

import Animations.ProgressBarAnimation
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.core.widget.doAfterTextChanged
import org.bedu.okayapp.databinding.ActivityProgressBinding

class Progress : AppCompatActivity() {
    private lateinit var binding: ActivityProgressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar = ProgressBarAnimation(
            binding.progressPogressBar,
            binding.progressPogressStatus,
            binding.progressTextPercentage
        )

        progressBar.setProgress(75)

        //ketzalli -> solo le agregue la acción al boton
        binding.progressBtnPlay.setOnClickListener {
            val intent = Intent(this, BaseQuestion::class.java)
            startActivity(intent)
        }
        //hasta aqui


    }
}