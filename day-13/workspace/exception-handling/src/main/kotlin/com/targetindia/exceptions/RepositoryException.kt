package com.targetindia.exceptions

//class RepositoryException(message: String) : RuntimeException(message)

class RepositoryException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(cause: Throwable?) : super(cause)
}