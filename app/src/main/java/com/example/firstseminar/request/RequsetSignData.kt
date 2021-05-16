package com.example.firstseminar.request

data class RequsetSignData(
        val email: String,
        val password : String,
        val sex :String,
        val nickname : String,
        val phone : String,
        val birth : String
        //string아닌거 같은데???
)