package org.bedu.okayapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
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

        binding.progressPogressStatus.text = "SIN PROGRESO"
        binding.progressTextPercentage.text = "-"
        initProgressBar(binding.progressPogressBar)
        //binding.progressTextPercentage.text = "0%"
        binding.progressPogressStatus.text = "EN PROGRESO"
        binding.progressTextPercentage.text ="${53}%"
        binding.progressPogressBar.setOnClickListener {
            if(binding.progress.visibility == View.INVISIBLE) {
                binding.progress.visibility = View.VISIBLE
            }
            else{
                binding.progress.visibility = View.INVISIBLE
            }

        }




        binding.progress.doAfterTextChanged {
            if ((binding.progress.text.length>0)&&(binding.progress.text.toString().toInt()>0)){

                when{
                    binding.progress.text.toString().toInt() <=50->{
                        binding.progressPogressStatus.text = "EN PROGRESO"
                        binding.progressTextPercentage.text ="${binding.progress.text.toString()}%"
                        setProgressAnimate(binding.progressPogressBar, binding.progress.text.toString().toInt())
                    }
                    binding.progress.text.toString().toInt() >50 &&  binding.progress.text.toString().toInt()<100->{
                        binding.progressPogressStatus.text = "AVANZADO"
                        binding.progressTextPercentage.text ="${binding.progress.text.toString()}%"
                        setProgressAnimate(binding.progressPogressBar,binding.progress.text.toString().toInt())
                    }
                    binding.progress.text.toString().toInt() ==100->{
                        binding.progressPogressStatus.text = "COMPLETADO"
                        binding.progressTextPercentage.text ="${100}%"
                        setProgressAnimate(binding.progressPogressBar,100)

                    }
                    else->{
                    }                    }
            }
            else{
                binding.progressPogressBar.progress = 0
                binding.progressTextPercentage.text ="0%"
                binding.progressPogressStatus.text = "SIN PROGRESO"
                setProgressAnimate(binding.progressPogressBar,0)

            }

        }

    }

}

private fun setProgressAnimate(pb: ProgressBar, progressTo: Int) {
    val animationProgress = ObjectAnimator.ofInt(pb, "progress", pb.progress, progressTo)
    animationProgress.duration = 1000
    animationProgress.interpolator = DecelerateInterpolator()
    animationProgress.start()

}


private fun initProgressBar(pb: ProgressBar){
    val animationTo100 = ObjectAnimator.ofInt(pb, "progress", 0, 100)
    animationTo100.duration = 750
    animationTo100.startDelay=450
    animationTo100.interpolator = DecelerateInterpolator()

    val animationTo0 = ObjectAnimator.ofInt(pb,"progress",100,53)
    animationTo0.duration = 750
    animationTo0.startDelay=100
    animationTo0.interpolator = DecelerateInterpolator()

    AnimatorSet().apply {
        playSequentially(animationTo100,animationTo0)
        start()

    }
}