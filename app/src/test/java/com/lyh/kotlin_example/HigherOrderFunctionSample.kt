package com.lyh.kotlin_example

import org.junit.Test

fun print(body: () -> String) {
    println(body())
}

fun print2(body: (String) -> String) {
    println(body("print"))
}

fun print3(body: (Int, String) -> String) {
    println(body(1, "two"))
}

fun print4(body: (a: Int, b: Int) -> Int) {
    println(body(1, 2))

}

fun plus(a: Int, b: Int) = a + b

class HigherOrderFunctionSample {

    lateinit var higherOrderFunction2: (String) -> Unit
    @Test
    @Throws(Exception::class)
    fun test() {
        print { "hello" }

        print2 { "message : $it" }

        print3 { one, two -> "message : $one, $two" }

        print4 { one, two -> plus(one, two) }

        var higherOrderFunction: () -> Unit = {
            println("highter order function")
        }

        higherOrderFunction()
        higherOrderFunction2 = {
            println(it)
        }

        higherOrderFunction2("higher order function2")

    }
}