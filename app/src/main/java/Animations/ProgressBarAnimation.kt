package Animations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import android.widget.TextView

class ProgressBarAnimation(progressBar: ProgressBar,pbText:TextView ,pbNum:TextView) {
    val pb = progressBar
    val pText = pbText
    val pNum = pbNum
    fun setProgress(progressTo: Int) {

        val numberAnimator = ValueAnimator.ofInt(pb.progress,progressTo)
        numberAnimator.duration=1000
        numberAnimator.interpolator=DecelerateInterpolator()
        numberAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener {
            pNum.text="${it.animatedValue}%"
            pb.progress = it.animatedValue.toString().toInt()
        })
        numberAnimator.start()
        animateTexts(progressTo)


    }



    fun initProgressBar() {
        val numberAnimator = ValueAnimator.ofInt(0,100)
        numberAnimator.duration=750
        numberAnimator.startDelay=450
        numberAnimator.interpolator=DecelerateInterpolator()
        numberAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener {
            pNum.text="${it.animatedValue}%"
            pb.progress = it.animatedValue.toString().toInt()
        })
        val numberAnimator2 = ValueAnimator.ofInt(100,0)
        numberAnimator2.duration=750
        numberAnimator2.startDelay=100
        numberAnimator2.interpolator=DecelerateInterpolator()
        numberAnimator2.addUpdateListener(ValueAnimator.AnimatorUpdateListener {
            pNum.text="${it.animatedValue}%"
            pb.progress = it.animatedValue.toString().toInt()
        })

        AnimatorSet().apply {
            playSequentially(numberAnimator,numberAnimator2)
            start()
            animateTexts(0)

        }
    }

    private fun animateTexts(progressValue:Int) {
        if ((progressValue > 0) && (progressValue > 0)) {

            when {
                progressValue <= 50 -> {
                    pText.text = "EN PROGRESO"


                }
                progressValue > 50 && progressValue < 100 -> {
                    pText.text = "AVANZADO"

                }
                progressValue == 100 -> {
                    pText.text = "COMPLETADO"
                }
                else -> {
                }
            }
        } else {
            pb.progress = 0
            pText.text = "SIN PROGRESO"

        }

    }
}





/*val animationTo100 = ObjectAnimator.ofInt(pb, "progress", 0, 100)
        animationTo100.duration = 750
        animationTo100.startDelay = 450
        animationTo100.interpolator = DecelerateInterpolator()

        val animationTo0 = ObjectAnimator.ofInt(pb, "progress", 100, 0)
        animationTo0.duration = 750
        animationTo0.startDelay = 100
        animationTo0.interpolator = DecelerateInterpolator()*/
