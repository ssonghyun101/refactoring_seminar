package com.example.firstseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("자기소개화면","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("자기소개화면","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("자기소개 화면","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("자기소개화면","onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("자기소개화면","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("자기소개화면","onDestroy")
    }
}