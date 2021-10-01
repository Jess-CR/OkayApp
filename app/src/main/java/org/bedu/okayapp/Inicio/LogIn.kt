package org.bedu.okayapp.Inicio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories
import org.bedu.okayapp.databinding.ActivityMainBinding
import org.bedu.okayapp.forgotPasword

class LogIn : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var log_in_btn_logIn:Button
    private lateinit var log_in_editText_email:EditText
    private lateinit var log_in_editText_password:EditText
    private lateinit var log_in_chkBox_remember:CheckBox
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_log_in)
        log_in_chkBox_remember=findViewById(R.id.log_in_chkBox_remember)
        log_in_btn_logIn =findViewById(R.id.log_in_btn_logIn)
        log_in_editText_email = findViewById(R.id.log_in_editText_email)
        log_in_editText_password = findViewById(R.id.log_in_editText_password)



        auth= FirebaseAuth.getInstance()

        /*DEBUG ALOPEZ
        val intent = Intent(this, Progress::class.java)
        startActivity(intent)*/
    }

    fun forgotPassword(view:View){
        startActivity(Intent(this,forgotPasword::class.java))
        finish()
    }

    fun loging(view:View){
      //  val sp = getSharedPreferences("myprefs", Context.MODE_PRIVATE)
       // checkLohin(sp)
        loginUser(/*sp*/)
    }

    private fun loginUser(/*sp:SharedPreferences*/){
        val user:String=log_in_editText_email.text.toString()
        val contrasena:String=log_in_editText_password.text.toString()

        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(contrasena)){
            val checkBox:String=log_in_chkBox_remember.isChecked.toString()
           /* if(checkBox.isEmpty()){
                with(sp.edit()){
                    putString("activa","true")
                    putString("remember","false")
                    apply()
                }
            }else{
                with(sp.edit()){
                    putString("correo",user)
                    putString("contrasena",contrasena)
                    putString("activa","true")
                    putString("remember","true")

                    apply()
                }
            }*/
            auth.signInWithEmailAndPassword(user,contrasena)
                .addOnCompleteListener(this){
                    task->
                    if(task.isSuccessful){
                        action()
                    }else{
                       Toast.makeText(this,"Error en la autenticación",Toast.LENGTH_LONG).show()
                    }
                }
        }else{
            Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG).show()
        }
    }
    private fun action(){
        startActivity(Intent(this,categories::class.java))
    }
    /*private fun checkLohin(sp:SharedPreferences){
        if(sp.getString("active","")=="true"){
            startActivity(Intent(this,forgotPasword::class.java))
        }else{
            if(sp.getString("remember","")=="true"){
                val user=log_in_editText_email.setText(sp.getString("email",""))
                val contra=log_in_editText_password.setText(sp.getString("password",""))
            }
           // val user: Set<Char> =log_in_editText_email.text.toString().toSet()
            //val contrasena: Set<Char> =log_in_editText_password.text.toString().toSet()

        }
    }*/
}
