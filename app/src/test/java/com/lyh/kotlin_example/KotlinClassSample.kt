package com.lyh.kotlin_example

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import org.junit.Test

class Sample constructor(private val name: String, private val age: Int) {

    // secondary constructor
    constructor(name: String) : this(name, 0) {
        println("secondary constructor - name : $name")
    }

    init {
        println("constructor - name : $name, age : $age")
    }
}

class Sample2 constructor(val name: String, val age: Int = 0)

class Sample3(name: String) {
    private val upperName = name.toUpperCase()

    init {
        println("Sample3 - name : $upperName")
    }
}

class Sample4 private constructor(val name: String)


abstract class Base(age: Int)

// 기본 클래스는 final. 상속 불가능한 클래스가 된다.
class UseBase constructor(age: Int) : Base(age)

open class OpenClass constructor(age: Int)

interface BaseInterface {
    fun getName(): String
}

class BaseImpl(private val name: String) : BaseInterface {
    override fun getName(): String = name
}


class TestClass {

    @Test
    @Throws(Exception::class)
    fun test() {
        Sample("first", 1)
        // 첫 번째 생성자 불린 후, 두 번째 생성자 호출 됨.
        Sample("secondary")

        Sample3("upperName")

        // private constructor
        // Sample4("private Constructor")
    }
}

open class CustomConstraintLayout(
    context: Context,
    attrs: AttributeSet?,
    defStyleAtr: Int
) : ConstraintLayout(context, attrs, defStyleAtr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)
}

//java에서 사용시, 모든 파라미터를 필요로 하게 된다. (생성자가 1개뿐)
open class CustomConstraintLayout2(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAtr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAtr)

//java에서 사용하더라도, 하나의 파라미터로 인스턴스 할 수 있다.
//jvm overload 키워드, 생성자 파리미터의 기본 값을 설정해야 가능함.
open class CustomConstraintLayout3 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAtr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAtr)

abstract class AbstractBase(val a: Int) {

    fun printBase() = println("base a : $a ")

    abstract fun abstractFun()
}

class AbstractBaseExtends(a: Int) : AbstractBase(a) {

    // open function이 아니여서, override 불가능
//   override printBase() = println("ExtendsClass : $a")

    override fun abstractFun() {
        println("ExtendsClass")
    }
}

interface BaseInterface2 {
    // java와는 달리, static final 의 개념이 아니다. 구현 클래스에서 변경 할 수 있다.
    var a: Int

    fun existingMethod()
    fun newDefaultMethod() {
        println("interface default Method : $a")
    }
}

class BaseInterface2Impl : BaseInterface2 {

    override var a: Int = 0

    override fun existingMethod() {
        println("Implement class")
    }

    override fun newDefaultMethod() {
        // 디컴파일을 해보면, newDefaultMethod라는 static 메서드를 가지는 클래스를 하나 만든다.
        // super에 접근 할 때, 해당 클래스의 static 함수로 접근하여 super로 접근하는 것 처럼 보이게 한다.
        // java에서는, 이 메서드를 반드시 override해야 하고, super에 접근 할 수 없게 된다.
        println("Implement class: can access super class")
        super.newDefaultMethod()
    }
}