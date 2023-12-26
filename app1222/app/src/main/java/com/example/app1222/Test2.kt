package com.example.app1222

// byte 타입 변수, java 및 kotlin 의 정수형 기본 타입은 Int 타입
val a1 : Byte = 0b00001011

val a2 : Short = 123
val a3 : Int = 123
// Long 타입의 데이터를 저장하기 위해서 L 접미사를 사용
val a4 : Long = 10L

val a5 : Float = 10.0F
val a6 : Double = 10.0

val a7 : Boolean = true;

// kotlin의 Char 타입은 자바와 달리 정수 타입과 호환되지 않음
val a8 : Char = 'A'

// kotlin 에서 String 타입은 Java와 동일하게 사용 가능
val a9 : String = "Hello world!!"

fun main() {
    println("a1 : $a1")
    println("a2 : $a2")
    println("a3 : $a3")
    println("a4 : $a4")
    println("a5 : $a5")
    println("a6 : $a6")
    println("a7 : $a7")
    println("a8 : $a8")
    println("a9 : $a9")

//    Kotlin 에서 Char 타입은 Java와 달리 정수 타입이 아님로 정수와 비교 시 오류 발생
//    println(a8 == 65)

//    자바와 동일하게 사용된 String 타입
    var str1 = "Hello \n World!!"
//    kotlin 에서 추가된 삼중따옴표 방식, 입력한 형태 그대로 사용 가능
//    trimIndent() : 문자열 앞의 공백을 삭제하는 명령어
    var str2 = """
        Hello
            World!
    """.trimIndent()

    println(str1)
    println(str2)

    println("\n----------------- ------------------\n")

    val title = "코틀린을 사용한 안드로이드"
//    문자열 템플릿 사용 시
    println("변수 출력 : $title, 함수 호출 : ${sum(10, 20)}, 직접 덧셈 : ${10 + 20}")
//    기존 방식 사용 시
    println("변수 출력 : " + title + ", 함수 호출 : " + sum(10, 20) + ", 직접 덧셈 : " + (10+20))

    println("\n----------------- Any -----------------\n")
//    Any : kotlin의 모든 데이터 타입을 저장할 수 있는 데이터 타입, java의 Object 타입과 같음
//    Any 타입의 변수에 정수 데이터 저장
    val data1:Any = 10
//    Any 타입의 변수에 문자열 데이터 저장
    val data2:Any = "hello"
//    Any 타입의 변수에 클래스의 객체를 저장
    var data3:Any = Test()
//    var 키워드로 만들어진 변수에 Any 데이터 타입을 지정하여 해당 변수에는 여러가지 타입의 데이터를 모두 저장할 수 있음
    data3 = 10

//    Unit : Kotlin 에서 해당 함수의 반환 값이 없다는 의미
//    java 의 void 와 같음
    println("\n----------------- Unit -----------------\n")
    some1()
    some2()

    println("\n----------------- Nothing -----------------\n")
//    Nothing : null 만 저장할 수 있는 데이터 타입
//    Nothing 를 함수의 반환 타입에 사용할 경우 null과 예외만 반환함

//    데이터 타입을 Nothing으로 지정하여 null만 저장함
    var data4:Nothing? = null // ? : null 을 허용하겠다는 의미
//    Null 이외의 데이터 타입을 저장하기 때문에 오류 발생
//    data4 = 100

//    Null 허용 / 불허용 : kotlin 는 모든 변수가 객체이기 때문에 null을 저장할 수 있는 가능성이 존재함
//    kotlin에서는 null 사용을 안전하게 하기 위해서 변수의 데이터 타입에 ? 를 사용하여 null을 허용하거나 불허용함
//    데이터 타입에 ?가 없으면 null 사용 불가
//    데이터 타입에 ?가 있으면 null 사용 가능
    var data5: Int = 10
    var data6: Int? = 10

    println("data5 : $data5")
    println("data6 : $data6")

//    변수 data5의 데이터 타입은 Int 이므로 null 사용 불가
//    data5 = null
//    변수 data6의 데이터 타입은 Int? 이므로 null 사용 가능
    data6 = null
}

class Test {}

fun sum(num1: Int, num2: Int): Int{
    var result = 0
    result = num1 + num2
    return result
}

// 반환 타입을 Unit 로 지정하여 반환값이 없음을 표시
fun some1():Unit{
    println(10 + 20)
}

// 반환 타입이 없을 경우 Unit 생략해도 상관 없음, 컴파일러가 자동으로 붙임
fun some2(){
    println(10 + 20)
}

// 반환 타입을 Nothing 타입으로 설정하여 null을 반환 받음
fun some3(): Nothing? {
    return null
}

// 반환 타입을 Nothing 타입으로 설정하여 예외만 반환 받음
// 사용자 예외 발생 시킬때 사용함
fun some4(): Nothing{
    throw Exception()
}















