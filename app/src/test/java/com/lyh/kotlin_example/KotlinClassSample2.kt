package com.lyh.kotlin_example

import org.junit.Test

open class A {

    open fun common() {
        println("A Class")
    }
}

interface B {
    fun common() {
        println("B Interface")
    }
}

class C : A(), B {

    override fun common() {
        // java와 다르게, A 클래스, B 인터페이스 모두의 함수 참조 가능. 명시 해주어야 한다.
        super<A>.common()
        super<B>.common()
    }
}

class UserInfo @JvmOverloads constructor(
    name: String = "",
    age: Int = 0,
    birthday: String = "0000-00-00"
) {
    val name: String
    val age: Int
    val birthday: String

    init {
        this.name = name.takeIf { it.isNotEmpty() } ?: ""
        this.age = age.takeIf { it > 0 } ?: 0
        this.birthday = birthday.takeIf { it.isNotEmpty() } ?: "0000-00-00"
    }
}

class InitBlockClass {

    constructor(name: String) {
        println("constructor : $name")
    }

    constructor(name: String, age: Int) : this(name) {
        println("second constructor : $name")
    }

    init {
        println("init block")
    }
}

class InitBlockClass2(name: String, private val age: Int) {

    init {
        println("init block : primary constuctor $name, $age")
    }

    constructor(name: String, age: Int, birthDay: String) : this(name, age) {
        println("second constructor : $name, $birthDay")
    }

    constructor(name: String) : this(name, 0) {
        println("third constructor : $name, $age")
    }
}

class Test {

    @Test
    @Throws(Exception::class)
    fun initBlockTest() {
        //init 블록 실행 후, constructor 블록 실
        val initBlockClass = InitBlockClass("name", 0)
        println(initBlockClass)
        println()

        val initBlockClass2 = InitBlockClass2("name", 22, "2010-01-02")
    }

}
