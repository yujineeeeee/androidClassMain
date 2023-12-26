package com.example.app1222

import com.google.android.material.color.utilities.Cam16

// 코틀린에서 변수, 함수를 클래스의 멤버로 포함하지 않아도 상관없음

// 변수 : 키워드 val, var 사용
// 코틀린의 변수는 데이터 타입 추론 방식을 사용함
// 변수의 데이터 타입을 직접 설정하고자 할 경우 변수명 뒤에 ": 타입" 을 사용

// val : 초기값 설정 후 변경할 수 없는 변수, 자바의 읽기 전용인 final 변수와 같음
// var : 초기값 설정 후 변경할 수 있는 변수, 자바의 일반적인 변수

// var 와 val 로 변수 선언
val data1 = 10
var data2 = 20

// 데이터 추론 방식으로 변수에 데이터 저장과 동시에 데이터 타입을 설정
val data3 = 30
// 변수 선언 시 데이터 타입을 설정
val data4 : Int = 40

// 코틀린에서 변수 선언 시 초기값을 설정하지 않고 변수만 선언할 경우 데이터 타입을 반드시 지정해야 함
// 함수 멤버 변수를 제외한 모든 변수는 선언과 동시에 초기값이 설정되어야 함
var data7 = 70
var data8 : Int = 80
// 초기값이 설정되지 않아서 오류 발생
//var data9 : Int
//var data10

// lateinit, by lazy {} 를 사용하여 변수의 초기값을 나중에 지정할 수 있음
// lateinit 은 var 키워드를 사용한 변수에만 사용 가능
// lateinit 은 코틀린의 기본 데이터 타입인 Byte, Short, Int, Long, Float, Double, Boolean 에는 사용할 수 없음

// by lazy {} 는 val, var 키워드 모두 사용할 수 있음
// by lazy {} 는 모든 데이터 타입에 적용할 수 있음
// by lazy {} 의 코드 블럭 안에서 간단한 연산이 가능함
// by lazy {} 의 코드 블럭 가장 마지막에 있는 데이터를 해당 변수의 초기값으로 사용

// Int 데이터 타입이므로 lateinit 사용 불가
//lateinit var data15 : Int
// val 키워드로 변수를 선언하여 lateinit 사용 불가
//lateinit val data16: String
// var 키워드 사용 및 String 데이터 타입이므로 lateinit 사용 가능
lateinit var data17 : String


// by lazy{} 를 사용하여 초기값을 사용 시 대입함
val data18 : Int by lazy {
//    중간에 여러가지 연산이 가능함
    println("in lazy.....")
//    가장 마지막 데이터가 실제로 대입되는 데이터
    10
}

class User{
//    클래스의 멤버 변수도 선언과 동시에 초기값을 설정해야 함
//    var data11
//    var data12 : Int
    var data13 = 130
    var data14 : Int = 140
}

fun main(){
    println("코틀린 실행하기.")

    println("data1 : $data1")
    println("data2 : $data2")

    println("data3 : $data3")
    println("data4 : $data4")

//    val 을 사용하여 데이터의 변경이 가능함
//    data1 = 100
//    var 을 사용하여 데이터의 변경이 가능함
    data2 = 200

//    변수 선언 시 데이터 타입이 없고, 초기 값도 없기 때문에 오류 발생, 데이터 타입 추론이 불가능하기 때문에 오류 발생
//    var data5
    var data6 : Int
    data6 = 60

    println("data6 : $data6")

    data17 = "나중에 초기화한 변수"
    println("data17 : $data17")


    println()
    println("in main....")
//    by lazy{} 로 초기화를 미루어 둔 변수를 최초로 사용
//    by lazy{} 의 코드 블럭에 있는 내용이 실행
//    코드 블럭 가장 마지막에 있던 데이터가  변수 data18에 대입됨
    println(data18)
    println(data18 + 10)
//    변수 data18 은 한번 초기화 했으므로 by lazy{} 의 코드 블럭을 실행하지 않음, 기존의 저장된 내용만 사용
    println(data18 + 10)

}