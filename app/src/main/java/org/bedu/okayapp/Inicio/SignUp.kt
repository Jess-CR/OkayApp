package org.bedu.okayapp.Inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import org.bedu.okayapp.R

class SignUp : AppCompatActivity() {

    private lateinit var sign_up_txt_title: TextView
    private lateinit var sign_up_editText_username:EditText
    private lateinit var sign_up_editText_email:EditText
    private lateinit var sign_up_editText_password:EditText
    private lateinit var sign_up_editText_passwordConfirmation:EditText
    private lateinit var sign_up_editText_profession:EditText
    private lateinit var sign_up_editText_date:EditText

    //Intenté poner el dropdown menu para seleccionar Estudiante o profesor
    //private val binding get() = binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_txt_title =findViewById(R.id.sign_up_txt_title)
        sign_up_editText_username=findViewById(R.id.sign_up_editText_username)
        sign_up_editText_email=findViewById(R.id.sign_up_editText_email)
        sign_up_editText_password=findViewById(R.id.sign_up_editText_password)
        sign_up_editText_passwordConfirmation=findViewById(R.id.sign_up_editText_passwordConfirmation)
        sign_up_editText_profession=findViewById(R.id.sign_up_editText_profession)
        sign_up_editText_date=findViewById(R.id.sign_up_editText_date)

        sign_up_editText_date.setOnClickListener{showDatePicker()}


        //Esta es la funcionalidad para el Dropdown menu
        /*val profession = resources.getStringArray(R.array.profession)
        val arrayAdapter= ArrayAdapter (requireContext(),R.layout.dropdown_item,profession)
        binding.autoCompleteTextView.setAdapter(ArrayAdapter)

        return binding.root*/

    }

    private fun showDatePicker() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager,"datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        sign_up_editText_date.setText("$day / $month / $year")
    }
}