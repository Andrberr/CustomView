package com.example.customview

class FanCounter() {
    companion object{
        var counter: Int = 0
        fun next() = ++counter
    }
}