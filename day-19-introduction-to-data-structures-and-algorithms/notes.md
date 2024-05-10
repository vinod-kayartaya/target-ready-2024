Big O notation

O(f(n))

--> describes the upper bound (worst case scenario) of growth rate of f(n), relative to the input size 'n'

O(1) --> order of 1
- constant time complexity

fun firstElement(n: Array<Int>): Int {
    return n[0]
}

O(n) --> order of n
- linear time complexity

fun total(n: Array<Int>): Int {
    var t = 0
    for(i in n){
        t +=i
    }
    return t
}

O(log n)
- logarithmic time complexity

O(n^2)
- quadratic time complexity


fun findMax(arr: Array<Int>): Int {
    var max = arr[0]                    // O(1)
    
    for(i in 1 until arr.size){         // O(n)
        if(arr[i] > max) {              // O(1)
            max = arr[i]                // O(1)
        }
    }
    
    return max                          // O(1)
}

O(log n)
--> binary search, check if n is prime

O(n^m)
-> bubble sort

O(2^n)
--> exponential time complexity
--> recursive functions

O(1) -> O(log n) -> O(n) -> O(n^m)

!n
--> n * !(n-1)

fun fact(n:Int):Int {
    if(n==1) return 1
    return n * fact(n-1)
}