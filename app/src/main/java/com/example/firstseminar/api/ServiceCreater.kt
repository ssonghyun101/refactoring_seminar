package com.example.firstseminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreater {
    //Retrofit interface 구현체

    //도메인(서버이름) 생성
    private const val BASE_URL = "http://cherishserver.com"

    // Retrofit 객체 생성
    private val retrofit : Retrofit = Retrofit.Builder()
            //빌더 객체의 baseUrl 함수 호출
            //서비스를 요청할 서버의 이름(domain)전달
        .baseUrl(BASE_URL)
            //retrofit과 gson은 서로 다른 라이브러리
            //json->dataClass로
            // 바꿔줄 Gson라리브러리 연결
        .addConverterFactory(GsonConverterFactory.create())
            //빌더 객체에서 해당함수 호출시
            //Retrofit 객체 반환
        .build()
//Retrofit 객체에서
    //create함수를 통해
    //interface 넘기기
    //라이브러리 구현체 만들기
    val soptService: SoptService = retrofit.create(SoptService::class.java)


}
