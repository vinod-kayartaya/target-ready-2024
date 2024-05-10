package com.targetindia.programs

import java.lang.RuntimeException

open class Person {
    var name: String = ""
    var email: String = ""
    var phone: String = ""

    constructor()
    constructor(name: String, email: String, phone: String) {
        this.name = name
        this.email = email
        this.phone = phone
    }


    open fun print() {
        println("Name    : $name")
        println("Email   : $email")
        println("Phone   : $phone")
    }
}

class Student : Person {
    var rollno: Int = 0
    var gpa: Double = 0.0
        set(value) {
            if (value < 0 || value > 5) {
                throw RuntimeException("invalid gpa. must be between 0 and 5")
            }
            field = value
        }

    constructor() : super()

    constructor(rollno: Int, name: String, email: String, phone: String, gpa: Double) : super(name, email, phone) {
        this.rollno = rollno
        this.gpa = gpa
    }


    override fun print() {
        println("Roll no : $rollno")
        super.print()
        println("GPA     : $gpa")
    }
}

fun main() {
    val p1 = Person()
    p1.name = "Vinod"
    p1.email = "vinod@vinod.co"
    p1.phone = "9731424784"

    p1.print()
    println()

    val s1 = Student()
    s1.name = "Ramesh"
    s1.email = "ramesh@xmpl.com"
    s1.phone = "98765876542"
    s1.rollno = 9876
    s1.gpa = 4.75

    s1.print()
    println()

    val s2=Student(5612, "Sujay", "sujay@xmpl.com", "6728281122", 4.8)
    s2.print()
}