package com.example.customview.operations_counter

class OperationsCounter {
    var counter: Int = 0
    fun next() = ++counter
    fun prev() = --counter
}