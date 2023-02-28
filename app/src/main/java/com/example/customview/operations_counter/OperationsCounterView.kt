package com.example.customview.operations_counter

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.MainActivity
import com.example.customview.R
import kotlin.math.min

class OperationsCounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        private const val radiusIncrease = 50
        private const val yellowValue = 11
        private const val redValue = 21
    }

    private var radius = 0.0f
    private var operationsCounter = OperationsCounter()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    private var mode = MainActivity.mode

    init {
        isClickable = true
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.OperationsCounterView,
            0, 0
        ).apply {
            try {
                operationsCounter.counter = getInteger(R.styleable.OperationsCounterView_startValue, 0)
            } finally {
                recycle()
            }
        }
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        mode = MainActivity.mode
        if (mode) operationsCounter.next()
        else operationsCounter.prev()
        contentDescription = operationsCounter.counter.toString()

        if (mode && operationsCounter.counter == yellowValue) radius += radiusIncrease
        else if (!mode && operationsCounter.counter == yellowValue - 1) radius -= radiusIncrease

        if (mode && operationsCounter.counter == redValue) radius += radiusIncrease
        else if (!mode && operationsCounter.counter == redValue - 1) radius -= radiusIncrease

        invalidate()
        return true
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (min(width, height) / 2.0 * 0.6).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (operationsCounter.counter < yellowValue) {
            paint.color = Color.GREEN
        } else if (operationsCounter.counter < redValue) {
            paint.color = Color.YELLOW
        } else {
            paint.color = Color.RED
        }
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
        paint.color = Color.BLACK
        canvas.drawText(
            operationsCounter.counter.toString(),
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            paint
        )
    }
}