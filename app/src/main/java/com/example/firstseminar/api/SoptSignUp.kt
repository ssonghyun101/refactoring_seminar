package com.example.firstseminar.api

import com.example.firstseminar.request.RequsetSignData
import com.example.firstseminar.response.ResponseSignData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptSignUp {
    //Retrofit interface 설계
    // 우리도 서버에 어떤 요청을 보내면
    // 어떻게 온다는 일종의 상호작용
    // 방법 정의!

    //회원가입 서버 Retrofit interface 설계

    @POST("/login/signup")
    fun postSign(
            @Body  body : RequsetSignData
    ) : Call<ResponseSignData>

}