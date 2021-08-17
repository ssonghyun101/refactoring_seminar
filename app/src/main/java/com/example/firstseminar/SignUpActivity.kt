package com.example.firstseminar
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstseminar.api.SignCreater
import com.example.firstseminar.api.SignCreater.soptSignUp
import com.example.firstseminar.databinding.ActivitySignUpBinding
import com.example.firstseminar.request.RequsetSignData
import com.example.firstseminar.response.ResponseSignData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("생명주기","oncreate()")
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)
        clickSignUp()

    }

    private fun clickSignUp() {

        binding.signupBtn.setOnClickListener{
            checkBlank()
        }
    }


    private fun checkBlank(){
        binding.apply {
            val pwd = signInnputPwd.text.toString()
            val email = signInputEmail.text.toString()
            val nickname = nicknameInput.text.toString()
            val phone  = phoneInput.text.toString()
            val birth  = birthInput.text.toString()

            if(email.isBlank() || pwd.isBlank() || nickname.isBlank()|| phone.isBlank()|| birth.isBlank() ){
                Toast.makeText(this@SignUpActivity,"빈 칸이 있는지 확인해주세요",
                    Toast.LENGTH_SHORT)
                    .show()
            }

            else{
                netWorkSignUp()
            }

        }
    }

    private fun netWorkSignUp(){
            //회원가입 버튼 클릭시
            //서버에 전달된 회원가입 데이터 출력
            // & SignIn Activity 이동

            //서버로 보내줄 data묶음들

            val requsetSignData=RequsetSignData(

                email = binding.signInputEmail.text.toString(),
                password= binding.signInnputPwd.text.toString(),
                nickname = binding.nicknameInput.text.toString(),
                phone = binding.phoneInput.text.toString(),
                birth = binding.birthInput.text.toString()

            )

            val call: Call<ResponseSignData> = soptSignUp
                .postSign(requsetSignData)

            call.enqueue(object : Callback<ResponseSignData> {
                override fun onResponse(

                    call: Call<ResponseSignData>,
                    response: Response<ResponseSignData>

                ) {
                    if (response.isSuccessful) {
                        val data = response.body()?.data
                        Toast.makeText(this@SignUpActivity, data?.nickname, Toast.LENGTH_LONG)
                            .show()

                        Log.d("회원가입 서버통신", "성공")
                        moveSignInView()


                    } else {
                        Log.d("회원가입 서버통신", "실패")
                    }

                }

                override fun onFailure(call: Call<ResponseSignData>, t: Throwable) {
                    Log.d("NetworkTest", "error")
                }
            })

    }

    private fun moveSignInView(){
        intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        startActivity(intent)
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






