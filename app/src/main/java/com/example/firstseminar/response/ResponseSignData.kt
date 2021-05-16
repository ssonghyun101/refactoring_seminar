package com.example.firstseminar.response

import com.google.gson.annotations.SerializedName

data class ResponseSignData(
        val success : Boolean,
        val message : String,
        val data : SignData?

) {

    data class SignData(
            @SerializedName("nickname")
            val nickname: String

    )
}