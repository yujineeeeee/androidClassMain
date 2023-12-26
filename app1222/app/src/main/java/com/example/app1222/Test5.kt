package com.example.app1222

import kotlin.jvm.internal.Ref.ShortRef

fun main(): Unit{
//    kotlin 에서 배열 생성
    val arrData1: Array<Int> = Array(5, {0})

    println(arrData1)
    
//    생성된 배열에 접근 시 [index]를 이용하여 접근
    arrData1[0] = 10
    arrData1[1] = 20
    arrData1[2] = 30
    arrData1.set(3, 40)
    arrData1.set(4, 50)

    println("""
        array size : ${arrData1.size}
        array data : ${arrData1[0]}, ${arrData1[1]}, ${arrData1.get(2)}, ${arrData1.get(3)}, ${arrData1[4]}
    """.trimIndent())

//    kotlin에서 제공하는 기본 타입 배열 클래스를 사용하여 배열 생성
//    ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, BooleanArray, CharArray 클래스 제공
//    기본 타입 배열 클래스 사용 시 타입이 지정되어 있기 대문에 컬렉션을 사용하지 않아도 됨
    println("\n------ 기본 타입 배열 클래스 사용 -------\n")

//    빈 배열 만드는 방식
    val arrByte: ByteArray = ByteArray(3, {0})
    val arrShort: ShortArray = ShortArray(3, {0})
    val arrInt: IntArray = IntArray(3, {0})
    val arrLong: LongArray = LongArray(3, {0})
    val arrFloat: FloatArray = FloatArray(3, {0.0F})
    val arrDouble: DoubleArray = DoubleArray(3, {0.0})
    val arrChar: CharArray = CharArray(3, {'a'})
    val arrBoolean: BooleanArray = BooleanArray(3, {false})

//    배열 선언과 동시에 데이터를 입력하는 방식
//    arrayOf() : kotlin에서 배열 생성과 동시에 지정한 값으로 초기화 하기 위한 함수
//    기본 타입 배열 클래스용 arrayOf()도 존재함
//    byteArrayOf(), shortArrayOf(), intArrayOf(), longArrayOf(), floatArrayOf(), doubleArrayOf(), charArrayOf(), booleanArrayOf()

    val array: Array<Int> = arrayOf(10, 20, 30)
    println(array[0])
    println(array[1])
    println(array[2])

    val arrInt2: IntArray = intArrayOf(10,20,30)
    println("arrInt2 : ${arrInt2[0]}, ${arrInt2[1]}, ${arrInt2[2]}")

    println("\n----------- List, Set, Map ------------\n")
//    리스트(불변 클래스) 기본 생성 방법
    var list1: List<Int> = List(3, {0})
//    listOf()를 사용하여 리스트(불변 클래스) 생성과 동시에 데이터 입력
    var list2 = listOf<Int>(10, 20, 30)

    println("""
        list1 size : ${list1.size}
        list1 data : ${list1[0]}, ${list1[1]}, ${list1.get(2)}
    """.trimIndent())

    println("""
        list2 size : ${list2.size}
        list2 data : ${list2[0]}, ${list2[1]}, ${list2.get(2)}
    """.trimIndent())

//    생성된 리스트가 불변 클래스 타입의 리스트이기 때문에 생성과 동시에 입력된 데이터를 읽기 전용으로만 사용할 수 있음
//    list1[1] = 200
//    list1.set(1, 200)
//    list2[1] = 200
//    list2.set(1, 200)

//    가변 클래스를 사용하여 리스트 생성
    var list3: MutableList<Int> = MutableList(3, {0})
//    mutableListOf()를 사용하여 가변 클래스를 사용한 리스트 생성
    var list4 = mutableListOf<Int>(10, 20, 30)

    println("""
        list3 size : ${list3.size}
        list3 data : ${list3[0]}, ${list3.get(1)}, ${list3[2]}
    """.trimIndent())

    println("""
        list4 size : ${list4.size}
        list4 data : ${list4[0]}, ${list4.get(1)}, ${list4[2]}
    """.trimIndent())

    list3[0] = 100
    list3.set(1, 200)

    list4[0] = 100
    list4.set(1,200)

    println("""
        list3 size : ${list3.size}
        list3 data : ${list3[0]}, ${list3.get(1)}, ${list3[2]}
    """.trimIndent())

    println("""
        list4 size : ${list4.size}
        list4 data : ${list4[0]}, ${list4.get(1)}, ${list4[2]}
    """.trimIndent())


    println()

    var map1 = mapOf<String, String>(Pair("one", "hello"), "two" to "world!!")
    var map2 = mutableMapOf<String, String>(Pair("one", "hello"), "two" to "world!!")

    println("""
        map1 size = ${map1.size}
        map1 data = ${map1.get("one")}, ${map1.get("two")}
        
        map2 size = ${map2.size}
        map2 data = ${map2.get("one")}, ${map2.get("two")}
    """.trimIndent())

//    불변 클래스로 map을 생성했기 때문에 값을 수정할 수 없음
//    map1["one"] = "헬로"
//    가변 클래스로 map을 생성했기 때문에 값을 수정할 수 있음
    map2.set("one", "bye")
    map2["three"] = "bring me home"

    println("""
         
        map2 size = ${map2.size}
        map2 data = ${map2.get("one")}, ${map2.get("two")}, ${map2.get("three")}
    """.trimIndent())

//    Map 컬렉션 멤버
//    get(key) : 지정한 key에 대응하는 value를 출력
//    set(key, value) : 지정한 key와 value를  Map에 저장
//    size : Map에 저장된 데이터의 수를 알려줌, 프로퍼티
//    count() : Map에 저장된 데이터의 수를 알려줌, 메소드
//    keys : Map 에 저장된 Key만 모두 모아서 출력
//    values : Map에 저장된 Value만 모두 모아서 출력
//    containsKey(키명) : 지정한 key가 Map에 저장되어 있는지 확인, 결과값은 true/false
//    containsValue(값) : 지정한 value가 Map에 저장되어 있는지 확인, 결과값은 true/false
//    remove(키명) : 지정한 key와 일치하는 데이터를 Map에서 삭제

    println("map2 size : ${map2.count()}, map2['three'] : ${map2["three"]}")

    val keys = map2.keys
    val values = map2.values

    println()

    println(keys)
    println(values)

    println(map2.containsKey("one"))
    println(map2.containsKey("aaa"))
    println(map2.containsValue("bye"))
    println(map2.containsValue("aaa"))

    println("map2 size : ${map2.size}")
    map2.remove("three")
    println("map2 size : ${map2.size}")
}

// var / var 구분
// 변수의 데이터 타입 설정 방법
// by lazy{} 의 개념과 사용법
// Unit 타입, Any 타입, null 허가/불허가 (데이터 타입에 ? 사용여부)
// 함수 선언 방법, fun 키워드, 매개변수 선언, 반환값 선언
// 배열 선언 방법, arrayOf(), 기본 타입 배열 클래스, 기본 타입 배열 클래스용 arrayOf()
// list, Map, MutableList, MutableMap