package com.targetindia.model

class Book(var title: String = "", var price: Double = 0.0) {

    override fun toString(): String {
        return "Book(title='$title', price=$price)"
    }
}