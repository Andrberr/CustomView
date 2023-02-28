package com.example.customview.counter_game

class FanCounter() {
    companion object{
        var counter: Int = 0
        fun next() = ++counter
    }
}