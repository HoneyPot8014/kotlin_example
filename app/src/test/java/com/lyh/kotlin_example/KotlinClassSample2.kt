package com.lyh.kotlin_example

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