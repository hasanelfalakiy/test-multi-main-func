package com.test

fun main() {
    print("Input number: ")
    val input = readLine()

    val number = input?.toIntOrNull()
    if (number == null) {
        println("Input not valid")
        return
    }

    println("Number = $number")
}