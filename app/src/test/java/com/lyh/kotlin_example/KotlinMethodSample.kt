package com.lyh.kotlin_example

import org.junit.Test

class MethodSample {

    fun noReturnFun(): Unit {
        // no return method
        // Unit 생략 가능
    }

    fun returnIntFun(): Int {
        return 1
    }

    private fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    private fun sum2(a: Int, b: Int) = a + b


    // extension function
    // fun 타입.함수명(파라미터): 리턴 타입 {}
    private fun Int.max(a: Int): Int
            = if (this >= a) this else a

    // Integer max2 a 의 형식으로 사용할 수 있다.
    // 파라미터가 하나 일 때만.
    private infix fun Int.max2(a: Int): Int
        = if (this >= a) this else a

    class ExtensionMethodTestClass {
        fun foo() = "not extension method"
    }

    fun ExtensionMethodTestClass.foo() = "extension method"

    // extension properties
    // 함수 뿐 아니라 프로퍼티도 확장 가능
    val <T>List<T>.lastIndex: Int
        get() = if(size > 0) size - 1 else 0


    @Test
    @Throws(Exception::class)
    fun test() {
        val a = 10
        val b = 20
        println("\nbasic method syntax")
        println("sum1 == sum2 : ${sum1(10, 20) == sum2(10, 20)}")
        println("10.max(20) : ${a.max(b)}")
        println("10 max2 20 : ${10 max2 20}")

        println("\nextension function")
        val clazz = ExtensionMethodTestClass()
        println("class.foo : ${clazz.foo()} => 확장함수보다 기존 클래스의 함수가 우선")

        println("\nextension properties")
        val list = mutableListOf<Int>(1, 2, 3, 4, 5)
        println("list : $list, extension property(last index) : ${list.lastIndex}")
    }

}