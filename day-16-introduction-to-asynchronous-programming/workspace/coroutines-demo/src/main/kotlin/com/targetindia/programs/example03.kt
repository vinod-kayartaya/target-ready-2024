package com.targetindia.programs

fun main() {
    println("start of main(), running in the thread ${Thread.currentThread().name}")
    val t1 = Thread(){
        printTable(5)
//        Thread.sleep(3*60*1000)
    }

    val t2 = Thread(){
        printTable(78)
//        Thread.sleep(60*1000)
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println("end of main(), running in the thread ${Thread.currentThread().name}")
}