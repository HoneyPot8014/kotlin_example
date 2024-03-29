package com.lyh.kotlin_example

import org.junit.Test

class MethodSample {

    fun noReturnFun() {
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
    private fun Int.max(a: Int): Int = if (this >= a) this else a

    // Integer max2 a 의 형식으로 사용할 수 있다.
    // 파라미터가 하나 일 때만.
    private infix fun Int.max2(a: Int): Int = if (this >= a) this else a

    class ExtensionMethodTestClass {
        fun foo() = "not extension method"
    }

    fun ExtensionMethodTestClass.foo() = "extension method"

    // extension properties
    // 함수 뿐 아니라 프로퍼티도 확장 가능
    val <T>List<T>.lastIndex: Int
        get() = if (size > 0) size - 1 else 0


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

    fun whenFunction(a: Any): String {
        val validNum = 1..10
        return when (a) {
            is String -> "NAN"
            in validNum -> "$a is in validRange"
            !in validNum -> "$a is not in vaildRange"
            else -> "else"
        }
    }

    fun loopFunction(list: List<Int>) {
        for (int in list) {
            print("$int ")
        }
        println()
    }

    fun loopIndex(list: List<Int>) {
        for (i in list.indices) {
            println("index : $i, value : ${list[i]}")
        }
    }

    fun loopWithIndexAndValue(list: List<Int>) {
        for ((index, value) in list.withIndex()) {
            println("index : $index, value : $value")
        }
    }

    fun loopWith2Step() {
        for (value in 0..10 step 2) {
            print("$value ")
        }
    }

    fun loopInMap(map: Map<Int, String>) {
        for ((key, value) in map) {
            println("key : $key, value : $value")
        }

    }

    @Test
    @Throws(Exception::class)
    fun controlFlow() {
        val a = 3
        val b = 100
        val c = "NAN"
        println("\n when flow")
        println("3 : ${whenFunction(a)}")
        println("100 : ${whenFunction(b)}")
        println("String : ${whenFunction(c)}")

        println("\n loop flow")
        val list = mutableListOf(1, 2, 3, 4, 5, 6)
        println("\n loop with iterator")
        loopFunction(list)
        println("\n loop with index")
        loopIndex(list)
        println("\n loop with index and value")
        loopWithIndexAndValue(list)
        println("\n loop with 2 step")
        loopWith2Step()
        println("\n loop in map")
        loopInMap(mutableMapOf(1 to "a", 2 to "b", 3 to "c", 4 to "d"))
    }

    private fun streamLabel1(list: List<Int>) {
        list.forEach {
            if(it == 3)  return
            print("$it ")
        }
        println("unreachable - function return!!")
    }

    private fun streamLabel2(list: List<Int>) {
        list.forEach{
            if(it == 3) return@forEach
            print("$it ")
        }
        println("reachable - only stream function return!!")
    }

    class ThisSample {
        private fun Int.thisTest() {
            val a = this@ThisSample
            val b = this
            val c = this@thisTest

//            println("a(this@ThisSample) === b(this) : ${a === b}")
            println("b(this) === c(this@thisTest) : ${b === c}")
        }

        fun foo() {
            10.thisTest()
        }
    }

    class ThisSample2 {

        inner class ThisSample3 {
            fun Int.foo() {
                val a = this
                val b = this@ThisSample2
                val c = this@ThisSample3
            }

            fun test() {
                10.foo()
                println("inner class test()")
                this@ThisSample2.test()
            }
        }

        fun test() {
            println("outer class test()")
        }
    }

    @Test
    @Throws(Exception::class)
    fun streamFunction() {
        val list = mutableListOf(1, 2, 3, 4, 5, 6)
        println("index * 2 of list element > 3 :  ${list.filter { it > 3 }.map { "index : $it, value : ${it * 2}" }}")
    }

    @Test
    @Throws(Exception::class)
    fun jumpExample() {
        println("\nlabel 1 test")
        outerLoop@ for (i in 0..100) {
            for (j in 0..10) {
                if (j > 5) break@outerLoop
                println("i : $i, j : $j")
            }
        }
        println("label 1 End")

        println("\nlabel 2 test")
        for (i in 0..1) {
            innerLoop@ for(j in 0..10) {
                if(j > 5) break@innerLoop
                println("i: $i, j : $j")
            }
        }
        println("label 2 End")

        println("\nlabel 3 test")
        val list = mutableListOf(1,2,3,4,5)
        streamLabel1(list)
        println("label 3 End")

        println("\nlabel 4 test")
        streamLabel2(list)
        println("label 4 End")
    }

    @Test
    @Throws(Exception::class)
    fun thisSample() {
        val clazz = ThisSample()
        clazz.foo()

        val thisClazz = ThisSample2().ThisSample3()
        thisClazz.test()
    }
}