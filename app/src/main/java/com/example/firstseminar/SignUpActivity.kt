package com.example.firstseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.Toast
import com.example.firstseminar.databinding.ActivitySignUpBinding
import com.example.firstseminar.request.RequsetSignData

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("생명주기","oncreate()")
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ClickSignUP()
    }

    private fun ClickSignUP() {

        binding.signupBtn.setOnClickListener(){
            // 모든 EditText에 데이터가 없는경우! - 
            //”빈 칸이 있는지 확인해 세요” 라고 사용자에게 보여줍니다

            var id : String = binding.signInputId.text.toString()
            // 왜 var ? 아 입력하는값이 그떄그떄 마다 달라서???
            var pwd : String = binding.signInnputPwd.text.toString()
            var name : String = binding.signInputName.text.toString()

            //일단 입력값들 다 받아오고!!!!!

            if(id.isBlank() && pwd.isBlank() && name.isBlank()){
                Toast.makeText(this,"빈 칸이 있는지 확인해주세요",
                    Toast.LENGTH_SHORT)
                    .show()
            }

            //- 모든 EditText에 데이터가 있는경우! - 
            //초기 SignUpActivity로 돌아갈 수 있도록 종료합니다 
            //종료 전에 꼭! putExtra를 이용해 모든 값을 intent에 넣어 전<합니다;

            else{
                //회원가입 버튼 클릭시
                //서버에 전달된 회원가입 데이터 출력
            // & SignIn Activity 이동
                val RequsetSignData=RequsetSignData(
                        //email, pwd,sex,nickname,phone,birth




                )





            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("회원 가입화면","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("회원가입 화면","onResume")
        //첫시작, 이 액티비티로 복귀했을 떄?
    }

    override fun onPause() {
        super.onPause()
        Log.d("회원가입화면 안보임","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("회원가입화면 종료","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("회원가입화면 완전 종료?","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("회원가입화면","onRestart")
    }
}