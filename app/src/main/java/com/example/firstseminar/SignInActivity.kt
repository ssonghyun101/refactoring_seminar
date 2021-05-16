package com.example.firstseminar

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstseminar.api.ServiceCreater
import com.example.firstseminar.databinding.ActivitySigninBinding
import com.example.firstseminar.request.RequsetLoginData
import com.example.firstseminar.response.ResponseLoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    //바인딩을 쓰기 위해 그레이들스크립트 - 빌드그레이들모듈 뭐시기에 가서 뭐써주는거 있는데 알아서보고왹
    //바인딩 클래스를 모든 범위에서 쓰기 위해서 젤 상단에 써준다!!!
    //커멜 표기법인 ActivityView 으로 바인딩 객체를 만든당!
    // 다른 사람이 메인액티비티에 접근해서 못바꾸게 private
    //나중에 초기화하기 위해서 lateinit를 써준다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //onCreate() : Activity가 실행되면서 최초 실행되는 메소드
        Log.d("첫번째화면","oncreate()")

        //뷰가 생성되는 순간에 바인딩 객체 생성 및 호출함수(inflate)!
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 사용할 뷰에 대한 참조. .root로 get호출
        //setContentView로 xml받아오기!

        SignUp()
        initButtonClickEvent()



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
                val requsetLoginData = RequsetLoginData(
                        email = binding.inputId.text.toString(),
                        password = binding.inputPwd.text.toString()
                )

                val call: Call<ResponseLoginData> = ServiceCreater.soptService
                        .postLogin(requsetLoginData)

                call.enqueue(object : Callback<ResponseLoginData> {
                    override fun onResponse(
                            call: Call<ResponseLoginData>,
                            response: Response<ResponseLoginData>
                    ) {
                        if(response.isSuccessful){
                            val data = response.body()?.data
                            Toast.makeText(this@SignInActivity,data?.user_nickname,Toast.LENGTH_SHORT)
                                    .show()

                            Log.d("서버통신","어서와 서버통신은 처음이지?")
                            intent = Intent(this@SignInActivity,HomeActivity::class.java)
                            startActivity(intent)

                        }else{
                            Log.d("서버통신","실패")



                        }

                    }

                    override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                        Log.d("NetworkTest","error:$t")
                    }


                })

            }

        }


    }



    private fun SignUp(){
        binding.signButton.setOnClickListener(){
            val nextIntent2 = Intent(this,SignUpActivity::class.java)
            startActivity(nextIntent2)
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


