package org.bedu.okayapp.Inicio

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

//vamos a recibir un parámetro que cuando se ejecute, le pasaremos los valores de día, mes y año
class DatePickerFragment(val listener: (day:Int, month: Int, year:Int) -> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    //cuando el usuario seleccione una fecha, en automático se llamará a este método
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {

        //este listener, ejecutará el código que se encuentra en el método shodDatePicker
        listener(dayofMonth, month, year)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //hay una clase Calendar
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val picker=DatePickerDialog(activity as Context, this, year,month, day)
        //timeInMillis, fecha actual en minisegundos
        picker.datePicker.maxDate= calendar.timeInMillis


        return picker
    }


}