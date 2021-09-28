package org.bedu.okayapp.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.bedu.okayapp.R
import org.bedu.okayapp.Temas.categories

class SignUp : AppCompatActivity() {

    private lateinit var sign_up_txt_title: TextView
    private lateinit var sign_up_editText_username:EditText
    private lateinit var sign_up_editText_email:EditText
    private lateinit var sign_up_editText_password:EditText
    private lateinit var sign_up_editText_passwordConfirmation:EditText
    private lateinit var sign_up_RadioGroup:RadioGroup
    private lateinit var signup_radioButton_student: RadioButton
    private lateinit var signup_radioButton_professor: RadioButton
    private lateinit var sign_up_editText_date:EditText
    private lateinit var sign_up_btn_continuar:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_txt_title =findViewById(R.id.sign_up_txt_title)
        sign_up_editText_username=findViewById(R.id.sign_up_editText_username)
        sign_up_editText_email=findViewById(R.id.sign_up_editText_email)
        sign_up_editText_password=findViewById(R.id.sign_up_editText_password)
        sign_up_editText_passwordConfirmation=findViewById(R.id.sign_up_editText_passwordConfirmation)
        signup_radioButton_professor=findViewById(R.id.signup_radioButton_professor)
        signup_radioButton_student=findViewById(R.id.signup_radioButton_student)
        sign_up_editText_date=findViewById(R.id.sign_up_editText_date)
        sign_up_RadioGroup=findViewById(R.id.sign_up_RadioGroup)

        sign_up_editText_date.setOnClickListener{showDatePicker()}


        //Esta es la funcionalidad para el Dropdown menu
        /*val profession = resources.getStringArray(R.array.profession)
        val arrayAdapter= ArrayAdapter (requireContext(),R.layout.dropdown_item,profession)
        binding.autoCompleteTextView.setAdapter(ArrayAdapter)

        return binding.root*/

//        sign_up_RadioGroup.setOnCheckedChangeListener{sign_up_Radiogroup, i ->
  //          var rb = findViewById<RadioGroup>(i)
    //    }


        activity_signUp()
    }

    private fun showDatePicker() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        sign_up_editText_date.setText("$day / $month / $year")
    }

    fun activity_signUp(){
        sign_up_btn_continuar.setOnClickListener {
            val ventanaLogIn: Intent = Intent(this, LogIn::class.java)
            startActivity(ventanaLogIn)
        }
    }
}