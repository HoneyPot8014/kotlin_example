package com.lyh.kotlin_example

import android.widget.TextView
import org.junit.Test

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
}
