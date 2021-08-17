package com.example.firstseminar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignCreater {

    //Retrogit interface 구현체

    //도메인(서버이름 설정)
    private const val BASE_URL = "http://cherishserver.com"

    //Retrofit 객체 생성
    private val retrofit : Retrofit = Retrofit.Builder()
    //빌더 객체에 BASE URL 함수 호출
    //서비스를 요청할 서버의 이름 전달
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val soptSignUp : SoptSignUp = retrofit.create(SoptSignUp::class.java)
}