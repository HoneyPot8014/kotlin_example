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

class CompanionClassSample {
    val name: String? = null

    companion object {
        // java에서 private static의 멤버로 type을 만든다.
        // kotlin에서 접근시 static처럼 접근하지만, java에서 Class.Companion.변수로 Companion 내부 클래스로 접근하게 된다.
        val TYPE: Int = 0

        fun isTypeZero() = TYPE == 0
    }

}

class CompanionClassSample2 {

    companion object {
        // const, @JvmStatic, @JvmField 키워드를 통해 java에서 바로 접근 가능할 수 있다.
        const val TYPE: Int = 0
        @JvmField val NAME: String = "name"
        @JvmStatic fun isTypeZero() = TYPE == 0
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

    @Test
    @Throws(Exception::class)
    fun companionTest() {
        // java 의 static처럼 접근
        CompanionClassSample.isTypeZero()

    }

}
