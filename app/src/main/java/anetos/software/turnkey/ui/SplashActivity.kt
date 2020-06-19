package anetos.software.turnkey.ui

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import anetos.software.turnkey.R
import anetos.software.turnkey.core.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {

    val ANIMATION_DURATION: Long = 1000

    lateinit var slideLeftToRight: Animation
    var slideDownAnimation: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContentView(R.layout.activity_splash)

        //startAnimation()
        /*slideDownAnimation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.slide_down
        )
        slideLeftToRight = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_left_right)
        iv_icon.startAnimation(slideDownAnimation)
        iv_name.startAnimation(slideLeftToRight)*/
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }

    private fun startAnimation() {
        // Intro animation configuration.
        val valueAnimator = ValueAnimator.ofFloat(0f, 1f)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            //titleSplash.scaleX = value
            //titleSplash.scaleY = value

        }
        //valueAnimator.interpolator = BounceInterpolaxtor()
        valueAnimator.duration = ANIMATION_DURATION

        // Set animator listener.
        val intent = Intent(this, MainActivity::class.java)
        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                // Navigate to main activity on navigation end.
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationStart(p0: Animator?) {}

        })

        // Start animation.
        valueAnimator.start()
    }

}
