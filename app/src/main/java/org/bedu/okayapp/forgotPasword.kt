package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.databinding.ActivityForgotPaswordBinding
import org.bedu.okayapp.databinding.ActivityLogInBinding

class forgotPasword : AppCompatActivity() {
   /* private lateinit var log_in_editText_email: EditText
    private lateinit var auth:FirebaseAuth*/
   private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityForgotPaswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPaswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()
        binding.logInBtnLogIn.setOnClickListener {
            val email = binding.logInEditTextEmail.text.toString()
            Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    val intent = Intent(this,LogIn::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Ingrese un email valido", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}