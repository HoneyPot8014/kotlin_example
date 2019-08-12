package com.lyh.kotlin_example

import android.graphics.Color
import android.widget.TextView
import org.junit.Test

// let
// 데이터 null 체크할 때 많이 사

// apply
// 객체의 생성과 동시에 초기화를 할 경우 유용

// run
// 이미 생성한 객체에 다시 접근

// with
// view에 접근할 때 주로 사

// also
// 두 개의 블록을 사용할 때 유용. this, it 키워드 사용

// take if
// if의 결과값이 true일 경우에만 자기 자신 return, false일 경우 null

// take unless
// take if와 반대

data class SampleData(val name: String, val age: Int)

class KotlinStandardLibSample {

    lateinit var nameTextView: TextView
    lateinit var ageTextView: TextView

    @Test
    @Throws(Exception::class)
    fun test() {
        val sampleData = SampleData("name", 22)

//        nameTextView.text = sampleData.name
//        ageTextView.text = sampleData.age.toString()

        sampleData.let {
            nameTextView.text = it.name
            ageTextView.text = it.age.toString()
        }
    }

    @Test
    @Throws(Exception::class)
    fun letTest() {
        val sample: String? = null

        sample?.let {
            println("sample: $sample")
        } ?: let {
            print { "null sample" }
        }
    }

    @Test
    @Throws(Exception::class)
    fun applyTest() {
        val textView: TextView? = TextView(null).apply {
            text = "textView"
            setTextColor(Color.BLACK)
            setOnClick(object : OnClickListener {
                override fun onClick() {

                }
            })
        }
    }


    @Test
    @Throws(Exception::class)
    fun runTest() {
        val textView: TextView? = null
        textView?.run {
            text = "hello"
            setTextColor(Color.BLACK)
        }
    }

    @Test
    @Throws(Exception::class)
    fun alsoTest() {

        val user = User("original", 10)
        val temp: User = user.copy(100)
        println(user)
        println(temp)

        println("take if ${temp.takeIf { it.age > 10 }}")
    }
}

data class User(var name: String = "copy User", var age: Int = 0)

fun User.copy(age: Int) = User().also {
    println("it :: name : $it.name, age: $it.age")
    println("this :: name : $this.name, age: $this.age")
    it.name = this.name
    it.age = age
}
