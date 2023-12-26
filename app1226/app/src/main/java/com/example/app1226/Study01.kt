package com.example.app1226

fun main() {

//    데이터 타입 추론 방식을 사용하기 때문에 변수 선언과 동시에 저장되는 데이터의 타입에 따라 변수의 데이터 타입이 결정 됨
//    변수의 선언과 동시에 값을 초기화 하는 것이 좋음
    var data1 = 10

//    자바의 if문과 동일하게 사용하는 것이 가능함
    if (data1 > 0){
        println("data1 > 0")
    }
    else{
        println("data1 <= 0")
    }


    if(data1 > 10){
        println("data1 > 10")
    }
    else if(data1 > 0 && data1 <= 10){
        println("data1 > 0 && data1 <= 10")
    }
    else{
        println("data1 <= 0")
    }

//    조건문을 표현식으로 사용하는 것이 가능함
    var result = if(data1 > 0){
        println("data1 > 0")
        true
    } else{
        println("data1 <= 0")
        false
    }

    println("result = $result")


//    자바에서 구현 시
    data1 = 10
    result = false

    if(data1 > 0){
        println("data1 > 0")
        result = true
    }
    else{
        println("data1 < 0")
        result = false
    }

    println("result = $result")


    println("\n------ when ------")

    var data2 = 10
    when(data2) {
        10 -> println("data2 = $data2")
        20 -> println("data2 = $data2")
        else -> {
            println("data2 is not valid data")
        }
    }

    var data3 = "hello"
    when(data3){
        "hello" -> println("data is hello")
        "world" -> println("data is world")
        else -> {
            println("data3 is not valid data")
        }
    }


//    is : 데이터 타입 확인 연산자, 지정한 데이터 타입이 맞으면 true 아니면 false 출력
//    in 시작 .. 종료 : 범위 지정 연산자, 시작부터 종료까지의 데이터에 포함되어 있으면 true 아니면 false
    var data4: Any = 10
    when(data4){
        is String -> println("data4 is String")
        20, 30 -> println("data4 is 20 or 30")
        in 1..10 -> println("data4 is 1..10")
        else -> println("data4 is not valid")
    }


//    when 도 표현식으로 사용이 가능함
//    when 사용 시 조건 데이터를 생략해도 상관 없음 (조건 데이터 생략 시 when 의 코드블럭 안에서 조건식을 직접 모두 입력해야 함)
    var data5 = 10
    var result1: String = when{
        data5 <= 0 -> "data5 is <= 0"
        data5 > 100 -> "data5 is > 100"
        else -> "data5 is valid"
    }

    println("result1 = $result1")


    var data6: Any = 10
    result1 = when(data6) {
        is String -> {
            println("data6 is String")
            "data6 is String"
        }
        20, 30 -> {
            println("data6 is 20 or 30")
            "data6 is 20 or 30"
        }
        in 1..10 -> {
            println("data6 is 1..10")
            "data6 is 1..10"
        }
        else -> {
            println("data6 is not valid")
            "data6 is not valid"
        }
    }

    println("result1 = $result1")

    println("\n----- 반복문 사용 -----")

    println("----- for문 -----")
//    in : 지정한 시작 숫자부터 지정한 종료 숫자까지 1씩 증가하며 반복, <=
//    until : 지정한 시작 숫자부터 지정한 종료 숫자까지 1씩 증가하며 반복, 종료 숫자는 포함하지 않음 <
//    step : 반복 시 마다 증가시킬 숫자의 크기를 지정
//    downTo : 반복 시 마다 감소시킬 숫자의 크기를 지정
    var sum1: Int = 0

//    코틀린의 for문은 자바의 향상된 for문으로 생각하면 됨
    for(i in 1..10){
        sum1 += i
        println("i : $i, sum1 : $sum1")
    }

    println("\n----- until -----")
    for(i in 1 until 10 ){
        println("i : $i")
    }

    println("\n----- step -----")
    for(i in 1..10 step 2){
        println("i : $i")
    }


    println("\n----- downTo -----")
    for(i in 10 downTo 1){
        println("i : $i")
    }

    println()

    for(i in 10 downTo 0 step 2){
        println("i : $i")
    }

    println("\n----- indices / withIndex() -----")
//    indices : 배열과 같은 컬렉션이 가지고 있는 index 출력
//    withIndex() : 배열과 같은 컬렉션이 가지고 있는 index와 value를 동시에 출력
    var arr = arrayOf(10, 20, 30, 40, 50)
    for(i in arr.indices){
        println("arr[$i] : ${arr[i]}")
    }

    println()

    arr = arrayOf(10, 20, 30, 40, 50)
    for((index, value) in arr.withIndex()){
        println("value : $value, index : $index")
    }

    println()

//    배열과 같은 컬렉션만 사용 시 자바의 향상된 for문을 사용하는 것과 동일한 형태로 사용 가능
    for(i in arr){
        println("i : $i")
    }

    println("\n----- while문 -----")
//    코틀린의 while문은 자바의 while문과 동일하게 사용함
    var x = 1
    sum1 = 0
    while(x < 11){
        sum1 += x
        println("x : $x, sum1 : $sum1")
        x++
    }


}