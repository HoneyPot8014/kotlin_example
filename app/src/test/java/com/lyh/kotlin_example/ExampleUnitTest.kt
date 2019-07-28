package com.lyh.kotlin_example

import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun test() {
        val a = 10000
        val b = 10000
        val c = "c"
        var d = "d"
        println("a == b : ${a == b}")
        println("c == d : ${c == d}")
        println("c === d : ${c === d}")
        d = "c"
        println("d = c, d == c : ${c == d}")
        println("d = c, d === c : ${c === d}")
        val boxedA: Int = a
        val anotherBoxedA: Int? = a
        println(boxedA == anotherBoxedA)

        val list = mutableListOf("a", 0, 1, "B")
        println("list : $list")

        val abc = "abc"
        for (ch in abc) {
            println("abc char at $ch")
        }
    }
}
