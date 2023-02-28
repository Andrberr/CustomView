package com.example.customview.counter_game

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var radius = 0.0f
    private var fanCounter = FanCounter.counter

    private val pointPosition: PointF = PointF(20.0f, 20.0f)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    private var time = 0L
    private var gameProcess = true

    init {
        isClickable = true
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        if (gameProcess) {
            fanCounter = FanCounter.next()
            contentDescription = fanCounter.toString()
            if (fanCounter == 1) {
                time = System.currentTimeMillis()
            }
            if (System.currentTimeMillis() >= time + 10000) {
                gameProcess = false
            }
        }
//        if (fanCounter == 10) {
//            radius += 30
//        } else if (fanCounter == 20) {
//            paint.color = Color.RED
//            radius += 30
//        }
        invalidate()
        return true
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (min(width, height) / 2.0 * 0.1).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (gameProcess) {
            if (fanCounter < 10) {
                paint.color = Color.GREEN
            } else if (fanCounter < 20) {
                paint.color = Color.YELLOW
            } else {
                paint.color = Color.RED
            }
            pointPosition.x = (0..width-radius.toInt()).random().toFloat()
            pointPosition.y = (0..height-radius.toInt()).random().toFloat()
            canvas.drawCircle(pointPosition.x, pointPosition.y, radius, paint)
            paint.color = Color.BLACK
            canvas.drawText(fanCounter.toString(), pointPosition.x, pointPosition.y, paint)
        } else canvas.drawText("Score = $fanCounter", 500.0F, 500.0F, paint)
    }
}