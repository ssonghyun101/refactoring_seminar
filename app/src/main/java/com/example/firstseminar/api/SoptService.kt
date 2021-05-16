package com.example.firstseminar.api
import com.example.firstseminar.request.RequsetLoginData
import com.example.firstseminar.response.ResponseLoginData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    //sopt 예제서버에서 서비스 제공받아서 이름 이렇게 지음

    //Retrofit interface 설계
    // 우리도 서버에 어떤 요청을 보내면
    // 어떻게 온다는 일종의 상호작용
    // 방법 정의!

    //로그인은 서버에
    // POST(데이터 제출, 이를 받아 서버 상태변경, 데이터 저장)
    // 행위 요청
    // /login/singnin 이란 식별자에 해당하는 데이터를
    // body에 담아 보낸다
  @POST("/login/signin")
    fun postLogin(
        // RequestLoginDataType  body 변수를
        // Request Body로 설정!
        @Body body : RequsetLoginData

    ) : Call<ResponseLoginData>

    //Retrofit에서 제공하는
    //동기 혹은 비동기 통신을
// 도와줌




}