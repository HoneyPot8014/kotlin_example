package com.lyh.kotlin_example

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val lazyInit:String by lazy {
        print("lazy init")
        "lazyinit"
    }

    // var = mutable 변수만 사용할 수 있다.
    // null 초기값 할 필요 없다.
    // 반드시 초기화 후 사용되어야 한다. (그 전에 사용시 에러 발생)
    private lateinit var lazyInit2:String

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

    @Test
    @Throws(Exception::class)
    fun test2() {
        val name: String? = "name"
        var nullName: String? = null
        println(nullName)
        nullName = "null"
        println(name?.length)
        println(nullName!!.length)

        //java - Void
        val nul: Nothing? = null

        //java - Object
        var any: Any?
        any = 10
        print("any : $any")
    }

    class Sample<T> {
        // var <property name>[: property type][ = property initializer]
        //   [getter]
        //   [setter]

        var list: List<T> = mutableListOf()
            private  set(value) {
                if(value.isNotEmpty()) {
                    field = value
                }
            }

        val isEmpty:Boolean
            get() = this.list.isEmpty()

    }

    @Test
    @Throws(Exception::class)
    fun lazyInit() {
        lazyInit

        //에러 발생
//        print(lazyInit2)
        lazyInit2 = "laztInit2"
        print(lazyInit2)
    }

}
