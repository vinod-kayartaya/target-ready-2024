package com.targetindia.utils.exceptions

class InvalidMonthException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(cause: Throwable?) : super(cause)
}