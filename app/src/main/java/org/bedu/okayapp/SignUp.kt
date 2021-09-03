package org.bedu.okayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView

class SignUp : AppCompatActivity() {

    private lateinit var sign_up_txt_title: TextView
    private lateinit var sign_up_editText_username:EditText
    private lateinit var sign_up_editText_email:EditText
    private lateinit var sign_up_editText_password:EditText
    private lateinit var sign_up_editText_passwordConfirmation:EditText
    private lateinit var sign_up_numPicker_age:NumberPicker
    private lateinit var sign_up_editText_profession:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_txt_title =findViewById(R.id.sign_up_txt_title)
        sign_up_editText_username=findViewById(R.id.sign_up_editText_username)
        sign_up_editText_email=findViewById(R.id.sign_up_editText_email)
        sign_up_editText_password=findViewById(R.id.sign_up_editText_password)
        sign_up_editText_passwordConfirmation=findViewById(R.id.sign_up_editText_passwordConfirmation)
        //sign_up_numPicker_age=findViewById(R.id.sign_up_numPicker_age)
        sign_up_editText_profession=findViewById(R.id.sign_up_editText_profession)

        sign_up_numPicker_age.minValue=0
        sign_up_numPicker_age.maxValue=99

    }
}