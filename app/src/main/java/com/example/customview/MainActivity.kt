package com.example.customview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.customview.operations_counter.OperationsCounterView

class MainActivity : AppCompatActivity() {

    var mode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = findViewById<OperationsCounterView>(R.id.customView)
        val operationsButton = findViewById<Button>(R.id.operationsButton)
        operationsButton.setOnClickListener {
            if (mode) {
                operationsButton.text = getString(R.string.decrease_text)
                mode = false

            } else {
                operationsButton.text = getString(R.string.increase_text)
                mode = true
            }
            counter.setMode()
        }
    }
}