package org.bedu.okayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.Profile
import org.bedu.okayapp.databinding.ActivityChangePasswordBinding
import java.util.regex.Pattern

class changePassword : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        val passwordRegex = Pattern.compile("^" +
                "(?=.*[-@#$%^/&+=])" +     // Al menos 1 carácter especial
                ".{6,}" +                // Al menos 8 caracteres
                "$")

        binding.chanButtonCambiarCon.setOnClickListener {
            val currentPassword = binding.changeEditPass.text.toString()
            val newPassword = binding.changeEditNew.text.toString()
            val repeatPassword = binding.changeEditConfir.text.toString()

            if (newPassword.isEmpty() || !passwordRegex.matcher(newPassword).matches()){
                Toast.makeText(this, "La contraseña es debil.",
                    Toast.LENGTH_SHORT).show()
            } else if (newPassword != repeatPassword){
                Toast.makeText(this, "Confirma la contraseña.",
                    Toast.LENGTH_SHORT).show()
            } else {
                chagePassword(currentPassword, newPassword)
            }
        }

    }

    private fun chagePassword(current: String, password: String) {
        val user = auth.currentUser
        if (user != null){
            val email = user.email
            val credential = EmailAuthProvider
                .getCredential(email!!, current)

            user.reauthenticate(credential)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {

                        user.updatePassword(password)
                            .addOnCompleteListener { taskUpdatePassword ->
                                if (taskUpdatePassword.isSuccessful) {
                                    Toast.makeText(this, "Se cambio la contraseña.",
                                        Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this, Profile::class.java)
                                    this.startActivity(intent)
                                }
                            }

                    } else {
                        Toast.makeText(this, "La contraseña actual es incorrecta.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}