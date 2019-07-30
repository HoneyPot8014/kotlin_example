package com.lyh.kotlin_example

import org.junit.Test

class Sample constructor(private val name: String, private val age: Int) {

    // secondary constructor
    constructor(name: String) : this(name, 0) {
        println("secondary constructor - name : $name")
    }

    init {
        println("constructor - name : $name, age : $age")
    }
}

class Sample2 constructor(val name: String, val age: Int = 0)

class Sample3(name: String) {
    private val upperName = name.toUpperCase()

    init {
        println("Sample3 - name : $upperName")
    }
}

class Sample4 private constructor(val name: String)

class TestClass {

    @Test
    @Throws(Exception::class)
    fun test() {
        Sample("first", 1)
        // 첫 번째 생성자 불린 후, 두 번째 생성자 호출 됨.
        Sample("secondary")

        Sample3("upperName")

        // private constructor
        // Sample4("private Constructor")
    }
}
