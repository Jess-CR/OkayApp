package org.bedu.okayapp.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories
import org.bedu.okayapp.ValidaEmail
import org.bedu.okayapp.databinding.ActivityLogInBinding
import org.bedu.okayapp.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

   /* private lateinit var sign_up_txt_title: TextView
    private lateinit var sign_up_editText_username:EditText
    private lateinit var sign_up_editText_email:EditText
    private lateinit var sign_up_editText_password:EditText
    private lateinit var sign_up_editText_passwordConfirmation:EditText
    private lateinit var sign_up_RadioGroup:RadioGroup
    private lateinit var signup_radioButton_student: RadioButton
    private lateinit var signup_radioButton_professor: RadioButton
    private lateinit var sign_up_editText_date:EditText
    private lateinit var sign_up_btn_continue:Button
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth*/
   private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()
        val passwordCarac = Pattern.compile("^"+
        "(?=.*[-@#$%^&+=])" +
        ".{8,}"+
        "$")

        binding.signUpBtnContinue.setOnClickListener {
            val email= binding.signUpEditTextEmail.text.toString()
            val password = binding.signUpEditTextPassword.text.toString()
            val validaPasword=binding.signUpEditTextPasswordConfirmation.text.toString()
            if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(baseContext,"Ingrese un email valido",Toast.LENGTH_LONG).show()
            }else if(password.isEmpty() || !passwordCarac.matcher(password).matches()){
                Toast.makeText(baseContext,"La contrasena es insegura",Toast.LENGTH_LONG).show()
            }else if(password != validaPasword){
                Toast.makeText(baseContext,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show()
            }else {
                createNewAccount(email,password)
            }
        }
        binding.signUpEditTextDate.setOnClickListener{showDatePicker()}
     /*   sign_up_txt_title =findViewById(R.id.sign_up_txt_title)
        sign_up_editText_username=findViewById(R.id.sign_up_editText_username)
        sign_up_editText_email=findViewById(R.id.sign_up_editText_email)
        sign_up_editText_password=findViewById(R.id.sign_up_editText_password)
        sign_up_editText_passwordConfirmation=findViewById(R.id.sign_up_editText_passwordConfirmation)
        signup_radioButton_professor=findViewById(R.id.signup_radioButton_professor)
        signup_radioButton_student=findViewById(R.id.signup_radioButton_student)
        sign_up_editText_date=findViewById(R.id.sign_up_editText_date)
        sign_up_RadioGroup=findViewById(R.id.sign_up_RadioGroup)
        sign_up_btn_continue=findViewById(R.id.sign_up_btn_continue)
        sign_up_editText_date.setOnClickListener{showDatePicker()}

        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        dbReference=database.reference.child("User")*/

    }
    private fun createNewAccount(email:String,password:String){
        val name = binding.signUpEditTextUsername.text.toString()
        val fecha = binding.signUpEditTextDate.text.toString()
        val profesion = binding.signUpRadioGroup.checkedRadioButtonId.toString()
        if (!TextUtils.isEmpty(name) &&!TextUtils.isEmpty(fecha) && !TextUtils.isEmpty(profesion)) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent=Intent(this,ValidaEmail::class.java)
                        startActivity(intent)
                    } else {
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }else{
            Toast.makeText(baseContext, "Llena todos los campos", Toast.LENGTH_LONG)
                .show()
        }
    }
    private fun showDatePicker() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        binding.signUpEditTextDate.setText("$day / $month / $year")
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

    private fun reload(){
        val intent= Intent(this, categories::class.java)
        this.startActivity(intent)
    }
   /* fun register(view:View){
        createNewAccount()
    }
    private fun createNewAccount(){
        val name:String=sign_up_editText_username.text.toString()
        val correo:String=sign_up_editText_email.text.toString()
        val contrasena:String=sign_up_editText_password.text.toString()
        val validaContrasena:String=sign_up_editText_passwordConfirmation.text.toString()
        val fecha:String=sign_up_editText_date.text.toString()
        val maestro:String=signup_radioButton_professor.shadowRadius.toString()
        val estudent:String=signup_radioButton_student.shadowRadius.toString()


    fun Profesor(){
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena) &&!TextUtils.isEmpty(validaContrasena) &&!TextUtils.isEmpty(fecha) && !TextUtils.isEmpty(maestro)){
            auth.createUserWithEmailAndPassword(correo,contrasena)
                .addOnCompleteListener(this){
                        task ->
                    if(task.isComplete){
                        val user:FirebaseUser?=auth.currentUser
                        if(contrasena == validaContrasena){
                            if (user != null) {
                                verifyEmail(user)
                            }
                            val userBd= user?.uid?.let { dbReference.child(it) }
                            userBd?.child("Usuario")?.setValue(name)
                            userBd?.child("Date")?.setValue(fecha)
                            userBd?.child("Cargo")?.setValue(maestro)

                            action()
                        }else{
                            Toast.makeText(this,"No coinciden contraseñas",Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }else{
            Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG).show()
        }
    }
    fun Estudiante(){
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena) &&!TextUtils.isEmpty(validaContrasena) &&!TextUtils.isEmpty(fecha) && !TextUtils.isEmpty(estudent)){
            auth.createUserWithEmailAndPassword(correo,contrasena)
                .addOnCompleteListener(this){
                        task ->
                    if(task.isComplete){
                        val user:FirebaseUser?=auth.currentUser
                        if(contrasena == validaContrasena){
                            if (user != null) {
                                verifyEmail(user)
                            }
                            val userBd= user?.uid?.let { dbReference.child(it) }
                            userBd?.child("Usuario")?.setValue(name)
                            userBd?.child("Date")?.setValue(fecha)
                            userBd?.child("Cargo")?.setValue(estudent)

                            action()
                        }else{
                            Toast.makeText(this,"No coinciden contraseñas",Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }else{
            Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG).show()
        }
    }

        Profesor()
        Estudiante()
    }

    private fun action(){
        startActivity(Intent(this,LogIn::class.java))
    }
    private fun verifyEmail(user: FirebaseUser){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if(task.isComplete){
                    Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Error al enviar email",Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun showDatePicker() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        sign_up_editText_date.setText("$day / $month / $year")
    }
*/

}