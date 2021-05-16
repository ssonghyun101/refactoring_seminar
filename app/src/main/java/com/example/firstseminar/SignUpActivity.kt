package com.example.firstseminar
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstseminar.api.SignCreater
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
        ClickSignUP()
    }

    private fun ClickSignUP() {

        binding.signupBtn.setOnClickListener(){
            // 모든 EditText에 데이터가 없는경우! - 
            //”빈 칸이 있는지 확인해 세요” 라고 사용자에게 보여줍니다

            var pwd : String = binding.signInnputPwd.text.toString()
            var email : String = binding.signInputEmail.text.toString()
            var Sex : String =  binding.sex.text.toString()
            var nickname : String = binding.nicknameInput.text.toString()
            var phone : String  = binding.phoneInput.text.toString()
            var birth : String = binding.birthInput.text.toString()

            //일단 입력값들 다 받아오고!!!!!

            if(email.isBlank() || pwd.isBlank() ||  Sex.isBlank()|| nickname.isBlank()|| phone.isBlank()|| birth.isBlank() ){
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

                //서버로 보내줄 data묶음들
                val requsetSignData=RequsetSignData(
                        email = binding.signInputEmail.text.toString(),
                        password= binding.signInnputPwd.text.toString(),
                        sex = binding.sex.text.toString(),
                        nickname = binding.nicknameInput.text.toString(),
                        phone = binding.phoneInput.text.toString(),
                        birth = binding.birthInput.text.toString()

                )

                val call: Call<ResponseSignData> = SignCreater.soptSignUp
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
                            intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                            startActivity(intent)

                        } else {
                            Log.d("회원가입 서버통신", "실패")
                        }

                    }

                    override fun onFailure(call: Call<ResponseSignData>, t: Throwable) {
                        Log.d("NetworkTest", "error")
                    }
                })

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






