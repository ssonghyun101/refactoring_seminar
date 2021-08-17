package com.example.firstseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstseminar.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    //바인딩을 쓰기 위해 그레이들스크립트 - 빌드그레이들모듈 뭐시기에 가서 뭐써주는거 있는데 알아서보고왹
    //바인딩 클래스를 모든 범위에서 쓰기 위해서 젤 상단에 써준다!!!
    //커멜 표기법인 ActivityView 으로 바인딩 객체를 만든당!
    // 다른 사람이 메인액티비티에 접근해서 못바꾸게 private
    //나중에 초기화하기 위해서 lateinit를 써준다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰가 생성되는 순간에 바인딩 객체 생성 및 호출함수(inflate)!
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // 사용할 뷰에 대한 참조. .root로 get호출
        //setContentView로 xml받아오기!

    }


}