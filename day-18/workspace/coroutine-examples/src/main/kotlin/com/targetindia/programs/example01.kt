package com.targetindia.programs

import kotlinx.coroutines.*

data class Weather(val city: String, val temperature: Double)

suspend fun fetchWeather(city: String): Weather {
    println("fetching weather for '${city}' in the stack of thread ${Thread.currentThread().name}")
    // simulation of a network call, fetching weather data from a web api
    delay(1000) // does not block the thread, removed from the thread, so that another suspending
    // method call may be executed on this thread

    // Thread.sleep(1000) blocks the current thread, until the delay is over
    val temperature = (Math.random() * 35) + 15
    return Weather(city, temperature)
}

fun main() {
    runBlocking {
        val cities = listOf<String>("Bangalore", "Chennai", "Hyderabad", "Mumbai", "Thiruvananthapuram")

        val deferredWeathers = cities.map {
            async {
                fetchWeather(it)
            }
        }

        println("going to wait for all weather data to be collected")
        val weathers = deferredWeathers.awaitAll()
        val avgTemp = weathers.map { it.temperature }.average()
        weathers.forEach { println("temperature in ${it.city} is ${it.temperature}") }
        println("average temperature in $cities is $avgTemp")
    }
}