package com.lyh.kotlin_example

import org.junit.Test

// kotlin 제너릭에 in / out 키워드를 사용
// java 제너릭의 와일드 카드처럼, in == super / out == extends

class GenericSample {

    @Test
    @Throws(Exception::class)
    fun test() {
        val temp: GenericImpl = GenericImpl()
        temp.run {
            printItem("hello")
        }

        printFunc("print function")
        printFunc(123)
    }

    @Test
    @Throws(Exception::class)
    fun test2() {
        printList(mutableListOf("aa", "bb", "cc"))
        println()
        printList(mutableListOf(1,2,3,4))
    }
}

interface Generic<in T> {
    fun printItem(item: T)
}

class GenericImpl: Generic<String> {
    override fun printItem(item: String) {
        println(item)
    }

}

fun <T> printFunc(item: T) {
    println(item)
}

fun printList(list: List<*>) {
    list.forEach {
        print("$it ")
    }
}