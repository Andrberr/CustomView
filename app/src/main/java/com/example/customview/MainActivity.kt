package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    companion object {
        var mode = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operationsButton = findViewById<Button>(R.id.operationsButton)
        operationsButton.setOnClickListener {
            if (mode) {
                operationsButton.text = getString(R.string.decrease_text)
                mode = false
            } else {
                operationsButton.text = getString(R.string.increase_text)
                mode = true
            }
        }
    }
}