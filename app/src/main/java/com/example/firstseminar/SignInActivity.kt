package com.example.firstseminar

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstseminar.databinding.ActivityMain2Binding
import com.example.firstseminar.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //바인딩을 쓰기 위해 그레이들스크립트 - 빌드그레이들모듈 뭐시기에 가서 뭐써주는거 있는데 알아서보고왹
    //바인딩 클래스를 모든 범위에서 쓰기 위해서 젤 상단에 써준다!!!
    //커멜 표기법인 ActivityView 으로 바인딩 객체를 만든당!
    // 다른 사람이 메인액티비티에 접근해서 못바꾸게 private
    //나중에 초기화하기 위해서 lateinit를 써준다
    // 근데 왜 variable 이지 ?????
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onCreate() : Activity가 실행되면서 최초 실행되는 메소드
        Log.d("첫번째화면","oncreate()")

        //뷰가 생성되는 순간에 바인딩 객체 생성 및 호출함수(inflate)!
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 사용할 뷰에 대한 참조. .root로 get호출
        //setContentView로 xml받아오기!

        initButtonClickEvent()
        //SignUp()
        GetData()



        //저기 있는 클릭이벤트를 실행해주는거 아 ㅋㅋㅋㅋㅋㅋㅋ 저게 이거구나.. 아...바본가.....


        }

    private fun initButtonClickEvent(){
        binding.loginButton.setOnClickListener{
            val user_id :String = binding.inputId.text.toString()
            val user_pwd : String = binding.inputPwd.text.toString()
            //사용자가 입력한 값 스트링으로 받아오기
            if(user_id.isBlank() || user_pwd.isBlank()) {
                //아이디가 비어있는 경우 실행함!!!
                Toast.makeText(this,
                    "아이디/비밀번호를 확인해주세요",
                    Toast.LENGTH_SHORT
                ).show()
                //가독성을 위해서 띄어주자
            }
            else{
                //여기 뭐한거냐 ㅠㅠㅠㅠㅠㅠㅠ 아 와이파이 끊기는거 개빡치네 진자 ㅜㅜㅜ
                //Toast.makeText(this,"안녕하세요",Toast.LENGTH_SHORT).show()
                //INTENT 홈액티비티로 이동!!!!!!!!! 그다음에 토스트 메시지 띄우기
                val nextIntent = Intent(this, HomeActivity::class.java)
                startActivity(nextIntent)

            }

        }


    }



    /*private fun SignUp(){
        binding.signButton.setOnClickListener(){
            val nextIntent2 = Intent(this,SignUpActivity::class.java)
            startActivity(nextIntent2)
        }
    }*/

    private fun GetData(){

        var intent = getIntent()
        if(intent.hasExtra("id")){
            //잘못된 값을 꺼내올 수 있기 때문에 null체크!

            // 첫번째버전
            binding.inputId.setText(intent.getStringExtra("id"))


            //언제든 다른값을 입력할 수 있어서 var로 해주기!! 근데 위에는 왜 val인거지

            /*두번째버전
            var user_id : String = binding.inputId.text.toString()
            user_id = intent.getStringExtra("id")
            binding.inputId.setText(user_id)
             */
        }

        if(intent.hasExtra("pwd")){
            //첫번째 버전
            binding.inputPwd.setText(intent.getStringExtra("pwd"))


            /*두번째버전
            var user_pwd : String = binding.inputPwd.text.toString()
            user_pwd = intent.getStringExtra("pwd")
            binding.inputPwd.setText(user_pwd)*/

        }
    }
    //생명주기 메소드는 AppCompatActivity 에 있으며, 오버라이드하여, 호출시마다 로그를 찍도록 설정해보
    override fun onStart() {
        super.onStart()
        Log.d("첫번째화면","onStart")
        //Activity가 다시 시작되기 전에 호출, Actvitiy가 멈춘 후 호출되는 함수, Activity가 사용자에게 보여지기 직전에 호출되는 함수
    }

    override fun onResume() {
        super.onResume()
        Log.d("다른 곳 가다가 첫번째화면 다시 켜짐","onResume")
        //Activity가 비로소 화면에 보여지는 단계, 사용자에게 Focus를 잡은 상태
    }

    override fun onPause() {
        super.onPause()
        Log.d("첫번째화면","onPause")
        //액티비티가 더 이상 화면에 안보임
    }

    override fun onStop() {
        super.onStop()
        Log.d("첫번째화면","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("첫번째화면 종료!!!","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("첫번째화면 재시작","onRestart")
    }





}