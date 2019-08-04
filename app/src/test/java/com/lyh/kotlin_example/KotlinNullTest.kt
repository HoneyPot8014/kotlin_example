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
}