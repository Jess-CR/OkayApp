package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.bedu.okayapp.Inicio.LogIn

class forgotPasword : AppCompatActivity() {
    private lateinit var log_in_editText_email: EditText
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pasword)
        log_in_editText_email = findViewById(R.id.log_in_editText_email)
        auth=FirebaseAuth.getInstance()
    }
    fun send(view:View){
        val email=log_in_editText_email.text.toString()
        if(!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this,LogIn::class.java))
                    }else{
                        Toast.makeText(this,"Error al enviar correo", Toast.LENGTH_LONG).show()
                    }
                }
        }else{
            Toast.makeText(this,"Llena el campo",Toast.LENGTH_LONG).show()
        }
    }
}