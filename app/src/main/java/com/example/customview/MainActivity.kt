package com.example.customview

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.customview.operations_counter.OperationsCounterView

class MainActivity : AppCompatActivity() {

    var mode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = findViewById<OperationsCounterView>(R.id.customView)
        val operationsButton = findViewById<Button>(R.id.operationsButton)
//        val animator = ValueAnimator.ofFloat(1f, 0f)
//        animator.addUpdateListener {animation ->
//            counter.alpha = (animation.animatedValue as Float)
//        }
//        animator.duration = 5000
//        val animator = ObjectAnimator.ofFloat(counter, View.ALPHA, 1f, 0f).apply {
//            duration = 20000
//        }
//
//        val animator2 = ObjectAnimator.ofFloat(counter, View.ROTATION_Y, 0f, 360f).apply {
//            duration = 10000
//        }
//
//        val animator3 = ObjectAnimator.ofFloat(counter, View.ROTATION_X, 0f, 360f).apply {
//            duration = 10000
//        }
//
//        val animator4 = ObjectAnimator.ofFloat(counter, View.ROTATION, 0f, 360f).apply {
//            duration = 10000
//        }
//
//        val buttonAnimator = ObjectAnimator.ofFloat(operationsButton, View.ROTATION, 0f, 360f).apply {
//            duration = 10000
//        }

        var rotate = 0f
        val set = AnimationUtils.loadAnimation(this, R.anim.animation)
        set.fillAfter = true
        operationsButton.setOnClickListener {
            if (mode) {
                operationsButton.text = getString(R.string.decrease_text)
                mode = false

            } else {
                operationsButton.text = getString(R.string.increase_text)
                mode = true
            }
            counter.setMode()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
         //   counter.startAnimation(set)
           // counter.animate().rotationXBy(rotate).rotationX(rotate + 200).start()
           // rotate+=180f
//            animator.start()
//            animator2.start()
//            animator3.start()
//            animator4.start()
//            buttonAnimator.start()
        }
    }
}