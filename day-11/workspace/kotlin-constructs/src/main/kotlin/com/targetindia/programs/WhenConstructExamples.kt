package com.targetindia.programs

fun evenOrOdd() {
    print("enter a number: ")
    val num = readln().toInt()

    when (num % 2) {
        0 -> println("$num is an even number")
        1 -> println("$num is an odd number")
    }
}

fun maxDaysInMonth() {
    print("enter a month number (1-12): ")
    val month = readln().toInt()
    var maxDays: Int

    when (month) {
        1, 3, 5, 7, 8, 10, 12 -> maxDays = 31
        4, 6, 9, 11 -> maxDays = 30
        2 -> maxDays = 28
        else -> maxDays = 0
    }

    if (maxDays == 0) {
        println("$month is an invalid number for a month")
    } else {
        println("month $month has $maxDays days")
    }
}

fun maxDaysInMonthV2() {
    print("enter a month number (1-12): ")
    val month = readln().toInt()

    // if(month !in 1..12){
    if (month !in 1..12) {
        println("$month is an invalid number for a month")
        return
    }

    var maxDays = 31

    when (month) {
        4, 6, 9, 11 -> maxDays = 30
        2 -> maxDays = 28
    }

    println("month $month has $maxDays days")
}

fun maxDaysInMonthV3() {
    print("enter a month number (1-12): ")
    val month = readln().toInt()

    // if(month !in 1..12){
    if (month !in 1..12) {
        println("$month is an invalid number for a month")
        return
    }

    print("enter a number for year (>0): ")
    val year = readln().toInt()
    if (year <= 0) {
        println("$year is an invalid number for an year")
        return;
    }
    var maxDays = 31

    when (month) {
        4, 6, 9, 11 -> maxDays = 30
        2 -> maxDays = if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) 29 else 28
    }

    println("month $month has $maxDays days in the year $year")
}

fun gradeForMarks() {
    print("enter marks (0 - 100): ")
    val marks = readln().toInt()

    //if(marks !in 0..100)
    if (marks !in 0..100) {
        println("invalid input, try again.")
        return
    }

    val grade: String
    when {
        marks < 35 -> grade = "F"
        marks < 45 -> grade = "C"
        marks < 60 -> grade = "B"
        marks < 80 -> grade = "A"
        else -> grade = "A+"
    }

    println("grade for marks $marks is \"$grade\"")

}

fun main() {
    print("enter marks (0 - 100): ")
    val marks = readln().toInt()

    //if(marks !in 0..100)
    if (marks !in 0..100) {
        println("invalid input, try again.")
        return
    }
    val grade = when {
        marks < 35 -> "F"
        marks < 45 -> "C"
        marks < 60 -> "B"
        marks < 80 -> "A"
        else -> "A+"
    }

    println("grade for marks $marks is \"$grade\"")

}