package com.targetindia.model

import java.lang.RuntimeException
import java.util.*

class Product {
    var id: Int = 0
        set(value) {
            if (value < 0) {
                throw RuntimeException("id must be >=0")
            }
            field = value
        } // this is the overwritten setter --> public final void setId(int id){...}
    var name: String = ""
        set(value) {
            var len: Int = value.trim().length
            if (len < 3 || len > 25) {
                throw RuntimeException("length of name must be between 3 and 25")
            }
            field = value.trim()
        }
        get() {
            return field.uppercase(Locale.getDefault())
        }
    var price: Double = 0.0
        set(value) {
            if (value < 0.0) {
                throw RuntimeException("price must be >= 0.0")
            }
            field = value
        }


    constructor(){
    }

    constructor(id: Int, name: String, price: Double) {
        // calls to the corresponding setter methods
        this.id = id
        this.name = name
        this.price = price
    }

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }


    override fun toString(): String {
        return "Product(id=$id, name='$name', price=$price)"
    }

}