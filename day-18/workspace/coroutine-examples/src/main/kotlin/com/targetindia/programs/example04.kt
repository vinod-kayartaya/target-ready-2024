package com.targetindia.programs

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import java.net.URL

// define a data class to hold the scraped data for the given URL
data class WebsiteData(val url: String, val content: String)

val myExceptionHandler = CoroutineExceptionHandler { _, exception ->
    println("OOPS! there was an error - $exception")
}

suspend fun fetchWebsiteData(url: String): String {
    println("trying to fetch data for url $url")
    // there are no suspending method calls here
    // which means, this will block the thread, not allowing any other suspending function
    // to execute

    // let's simulate a suspending method call
    delay(1000)
    return URL(url).readText()
}

suspend fun main() {
    val websites = listOf<String>(
        "https://vinod.co",
        "https://example.com",
        "https://kotlinlang.org/",
        "https://kvinod.com", // this is a non-existing website; cause of an exception
        "https://reactjs-movie-browser.web.app"
    )


    val myScraperScope = CoroutineScope(Dispatchers.IO + myExceptionHandler)
    // this is a shared data structure (across multiple coroutines)
    val scrapedData = mutableListOf<WebsiteData>()

    // if you want the shared resource should not be shared by more than 2 coroutines,
    // then we can define a semaphore and use the same while we are accessing the
    // shared resource
    val semaphore = Semaphore(2)

    websites.map { url ->
        myScraperScope.launch {
//            semaphore.acquire()
//            try {
                val content = fetchWebsiteData(url)
                scrapedData.add(WebsiteData(url, content))
//            } catch (e: Exception) {
//                println("failed to fetch data for url $url")
//            } finally {
//                semaphore.release()
//            }
        }
    }.forEach { it.join() }

    scrapedData.forEach {
        println("URL: ${it.url}\nContent length: ${it.content.length}\n")
    }

    println("end of main()")
}