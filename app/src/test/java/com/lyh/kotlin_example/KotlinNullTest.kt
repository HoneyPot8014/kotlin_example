package com.lyh.kotlin_example

import org.junit.Before
import org.junit.Test

class NullTest {

    @Before
    fun setUp() {

    }

    private fun setInfo(a: String, b: String?) {
        println("a :$a, b : $b")
    }

    private fun getSize(a: String?) = a?.length

    @Test
    @Throws(Exception::class)
    fun test() {
//        첫 번째 파라미터는 널을 허용하지 않음. 컴파일 타임에서 에러 발생
//        setInfo(null, null)
        setInfo("ABC", null)
    }

    @Test
    @Throws(Exception::class)
    fun test2() {
        val temp: String? = null
        val size = getSize(temp)
        println(size)
    }

    data class AAA(val bbb: BBB?)
    data class BBB(val ccc: CCC?)
    data class CCC(val name: String?)

    @Test
    @Throws(Exception::class)
    fun test3() {
        val aaa: AAA? = AAA(BBB(null))
        val name = aaa?.bbb?.ccc?.name
        println("name : $name")
    }

    @Test
    @Throws(Exception::class)
    fun test4() {
        val temp: String? = null
        // NPE 발생
        // val size = temp!!.length ?: 0

        val size = try {
            temp!!.length
        } catch (e: NullPointerException) {
            0
        }

        val size2 = temp?.length ?: throw NullPointerException("temp is null")
    }

    @Test
    @Throws(Exception::class)
    fun classCastingExample() {
        val a: Any? = "Any"

        // class casting Exception
        // val b: Int? = a as Int

        // java 디컴파일로 보면, instance of로 확인해줌.
        val b: Int? = a as? Int

        when (a) {
            is Int -> println(a)
            is String -> println(a)
            else -> println("nothing")
        }
    }

    @Test
    @Throws(Exception::class)
    fun streamNullTest() {
        val list = mutableListOf(null, "a", "b", "c", "d", null)
        val notNullList = list.filterNotNull()
        notNullList.forEach {
            print("$it ")
        }
    }
}