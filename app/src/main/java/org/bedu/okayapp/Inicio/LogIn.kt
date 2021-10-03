package org.bedu.okayapp.Inicio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories
import org.bedu.okayapp.ValidaEmail
import org.bedu.okayapp.databinding.ActivityLogInBinding
import org.bedu.okayapp.databinding.ActivityMainBinding
import org.bedu.okayapp.forgotPasword

class LogIn : AppCompatActivity() {

  /*  private lateinit var log_in_btn_logIn:Button
    private lateinit var log_in_editText_email:EditText
    private lateinit var log_in_editText_password:EditText
    private lateinit var log_in_chkBox_remember:CheckBox*/

    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()
        binding.logInBtnLogIn.setOnClickListener {
            val email= binding.logInEditTextEmail.text.toString()
            val password=binding.logInEditTextPassword.text.toString()
            SingIn(email,password)
        }

        /*DEBUG ALOPEZ
        val intent = Intent(this, Progress::class.java)
        startActivity(intent)*/
    }
    private fun SingIn(email:String,password:String){
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                task->
                if(task.isSuccessful){
                    Log.d("TAG","signInWithEmail:success")
                    reload()
                }else{
                    Log.w("TAG","signInWithEmail:failure",task.exception)
                    Toast.makeText(baseContext,"Authentication failed", Toast.LENGTH_LONG).show()
                }
            }
        }else{
            Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG).show()
        }
    }
    private fun reload(){
        val intent=Intent(this,categories::class.java)
        this.startActivity(intent)
    }

    fun forgotPassword(view:View){
        startActivity(Intent(this,forgotPasword::class.java))
        finish()
    }
    public override fun onStart(){
        super.onStart()
        val currentUser =auth.currentUser
        if(currentUser != null){
            if(currentUser.isEmailVerified){
                reload()
            }else{
                val intent= Intent(this,ValidaEmail::class.java)
                startActivity(intent)
            }

        }
    }


}
