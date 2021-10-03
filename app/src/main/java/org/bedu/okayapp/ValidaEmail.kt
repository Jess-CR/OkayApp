package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Temas.categories
import org.bedu.okayapp.databinding.ActivitySignUpBinding
import org.bedu.okayapp.databinding.ActivityValidaEmailBinding

class ValidaEmail : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityValidaEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valida_email)
        binding = ActivityValidaEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        val user = auth.currentUser
        binding.validaEmailButton.setOnClickListener {
            val profileUser= userProfileChangeRequest {  }
            user!!.updateProfile(profileUser).addOnCompleteListener{
                task->
                if(task.isSuccessful){
                    if(user.isEmailVerified){
                        reload()
                    }else{
                        Toast.makeText(this,"Verifica correo", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
    public override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            if(currentUser.isEmailVerified){
                reload()
            }else{
                sendEmailVerif()
            }

        }
    }
    private fun reload(){
        val intent= Intent(this, LogIn::class.java)
        this.startActivity(intent)
    }
    private fun sendEmailVerif(){
        val user = auth.currentUser
        user!!.sendEmailVerification().addOnCompleteListener(this){
            task->
            if(task.isSuccessful){
                Toast.makeText(this,"Email nviado", Toast.LENGTH_LONG).show()
            }
        }
    }

}