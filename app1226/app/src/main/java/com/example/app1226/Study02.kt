package com.example.app1226

// 코틀린에서 클래스 생성
class User1 {}

// 빈 클래스의 경우 {} 생략 가능
class User2

// 주 생성자를 사용한 클래스
class User4 constructor() {}

// 주 생성자의 constructor 키워드를 생략한 클래스
class User5() {}

// 클래스의 주 생성자에 매개변수가 없는 기본 생성자일 경우 () 도 생략 가능함
class User6 {}

// 주 생성자 사용 시 주 생성자의 매개변수 사용 및 소스코드를 실행하기 위해서 init 코드 블럭을 사용함
// 주 생성자의 매개변수는 init 코드블럭 내에서만 사용 가능
class User7 constructor(name: String, count: Int){
    var name = ""
    var count = 0

    init {
        println("i am init....")
        println("name : $name, count : $count")
        this.name = name
        this.count = count
    }

    fun someFun(){
        println("name : $name, count : $count")
    }
}

// 주 생성자의 매개변수에 var, val 키워드를 사용하면 해당 클래스의 필드로 선언됨
class User8(val name: String, val count:Int){
//    주 생성자의 매개변수에 val, var 키워드를 사용하여 주 생성자의 매개변수를 해당 클래스의 필드로 사용함
//    클래스의 필드를 따로 선언하지 않아도 되며, init {} 에서 초기화 작업을 하지 않아도 됨
//    val name = ""
//    val count = 0
//
//    init {
//        this.name = name
//        this.count = count
//    }
    fun someFun(){
        println("name : $name, count : $count")
    }
}

// 보조 생성자를 사용하는 클래스 작성
class User9 {
//    보조 생성자를 생성자 오버로딩에 의해서 여러 개의 생성자를 사용할 수 있음
    constructor(name: String){
        println("매개변수가 1개인 보조 생성자 호출")
    }

    constructor(name: String, count: Int){
        println("매개변수가 2개인 보조 생성자 호출")
    }
}


// 주 생성자와 보조 생성자를 함께 사용하는 클래스는 반드시 보조 생성자에서 주 생성자를 호출하는 부분이 필요함
class User10(name: String){
//    주 생성자의 init{} 코드 블럭
    init {
        println("매개 변수가 1개인 주 생성자 호출")
    }

//    보조 생성자 (this(name)을 이용해 주 생성자 호출)
//    자바의 this() 키워드와 같이 this()가 해당 생성자보다 먼저 실행됨
    constructor(name: String, count: Int): this(name){
        println("매개 변수가 2개인 보조 생성자 호출")
    }

//    보조 생성자
    constructor(name: String, count: Int, email: String): this(name, count){
        println("매개 변수가 3개인 보조 생성자 호출")
    }
}

// 코틀린의 클래스는 기본적으로 상속 불가능
// 코틀린의 클래스를 부모 클래스로 사용 시 open 키워드 추가
// 코틀린의 상속 시 extends 대신 : 사용
// 코틀린의 클래스에서 상속관계에 있는 자식 클래스는 부모 클래스의 생성자를 반드시 호출해야 함
open class Super(name: String){

}

class Sub: Super{
    constructor(name: String): super(name){

    }
}


// 코틀린에서 일반적인 클래스 생성
class User{
//    클래스의 멤버 변수, 필드 선언
    var name: String = "shin"

//    클래스의 생성자 선언
    constructor(name: String){
        this.name = name
    }

//    클래스의 메소드 선언
    fun someFun(){
        println("name : $name")
    }
}

fun main() {
//    변수 선언과 동시에 객체 생성
    var user: User = User("홍길동")
    user.someFun()

//    빈 변수를 먼저 선언
    var user1: User
//    나중에 변수에 객체를 생성하여 대입
    user1 = User("홍길동")
    user1.someFun()


//    빈 클래스를 이용하여 객체 생성
    val user2 = User2()
    val user3 = User1()
    val user4 = User4()
    val user5 = User5()
    val user6 = User6()

    val user7 = User7("홍길동", 10)
    user7.someFun()

    val user8 = User8("홍길동", 10)
    user8.someFun()

    val user91 = User9("홍길동")
    val user92 = User9("홍길동", 10)

    println()
//    주 생성자 사용하여 호출
    val user101 = User10("홍길동")
    println()
    val user102 = User10("홍길동", 10)
    println()
    val user103 = User10("홍길동", 10, "이메일")
}














