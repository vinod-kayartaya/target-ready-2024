package com.targetindia.programs

import java.io.BufferedReader
import java.io.FileReader

fun main1(args: Array<String>) {
    val filename = if (args.isEmpty()) "./build.gradle.kts" else args[0]

    val content = FileReader(filename).use { reader ->
        reader.readText()
    } // reader.close() is called

    println(content);
}

fun main(args: Array<String>) {
    val filename = if (args.isEmpty()) "./build.gradle.kts" else args[0]

    // it refers to the element in the current context,
    // in this example, the `use()` passes the object on which it is called (i.e, FileReader object)
    // and the variable `it` holds a reference to that object (of FileReader class)
    val content = FileReader(filename).use { it.readText() } // .use { reader -> reader.readText() }
    println(content);

}