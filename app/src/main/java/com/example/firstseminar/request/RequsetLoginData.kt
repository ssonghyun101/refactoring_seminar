package com.example.firstseminar.request

import com.google.gson.annotations.SerializedName

data class RequsetLoginData(
        val success : Boolean,
        val message : String,
        val password : String,
        val data: Data?
        )
{
    data class Data(
            @SerializedName("UserId")
            val userId:Int,
            val user_nickname : String,
            val token : String
//API문서에 나와있는 LoginData 자원 데이터 형식
    )

}


