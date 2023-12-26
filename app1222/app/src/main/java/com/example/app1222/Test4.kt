package com.example.app1222

// 문제1) Test4 파일 생성 후 사직 연산을 위한 함수 4개를 선언하고 실행하는 프로그램을 작성하세요
// # add(매개변수만 있는 형식), sub(반환값만 있는 형식), multi(매개변수와 반환값이 있는 형식), div(매개변수와 반환값이 없는 형식) 함수 선언

fun main() {
    add(10, 20)

    var result = sub()
    println("sub : $result")

    result =  multi(10, 20)
    println("multi : $result")

    div()
}

fun add(num1: Int, num2: Int){
    println("add : ${num1 + num2}")
}

fun sub(): Int{
    return 10 - 20
}

fun multi(num1: Int, num2: Int): Int{
    return num1 * num2
}

fun div(){
    println("div : ${10 / 20}")
}