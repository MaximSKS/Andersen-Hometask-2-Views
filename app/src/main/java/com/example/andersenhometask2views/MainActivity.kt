package com.example.andersenhometask2views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val secondsClockLineImageView = findViewById<ImageView>(R.id.image_seconds_line)
        val rotationAnim = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.9f
        )
        rotationAnim.interpolator = LinearInterpolator()
        rotationAnim.startOffset = 0
        rotationAnim.duration = 60000
        rotationAnim.repeatCount = Animation.INFINITE
        secondsClockLineImageView.startAnimation(rotationAnim)

    }

}

