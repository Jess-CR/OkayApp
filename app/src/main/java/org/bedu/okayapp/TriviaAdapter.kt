package org.bedu.okayapp
/*
ketzalli
se encarga de hacer funcionar los recyclerview de las preguntas

pendientes:
implementar la seleccion aleatoria de preguntas (sin repetirse)
implementar la base de datos
 */
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//variables de control
var correctas: Int = 0
var intentos: Int = 0

class TriviaAdapter(
    private var listaSE: ArrayList<SexualEducationDC>,
    private var contexto: Context
) : RecyclerView.Adapter<TriviaAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false),
            contexto
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaSE[position])
    }

    override fun getItemCount(): Int {
        return listaSE.size
    }

    class ViewHolder(private var view: View, private var contexto: Context) :
        RecyclerView.ViewHolder(view) {
        //declarar variables
        val pregunta: TextView
        val imagen: ImageView
        val boton1: Button
        val boton2: Button
        val boton3: Button
        var resCorrecta: Int

        //inicializar variables
        init {
            pregunta = view.findViewById(R.id.pregunta)
            imagen = view.findViewById(R.id.imagen)
            boton1 = view.findViewById(R.id.boton1)
            boton2 = view.findViewById(R.id.boton2)
            boton3 = view.findViewById(R.id.boton3)
            resCorrecta = 0
        }

        fun bind(sexualEducationDC: SexualEducationDC) {
            //asignar los valores a su respectivo componente
            pregunta.text = sexualEducationDC.questions
            imagen.setImageResource(sexualEducationDC.imageQ)
            boton1.text = sexualEducationDC.options1
            boton2.text = sexualEducationDC.options2
            boton3.text = sexualEducationDC.options3
            resCorrecta = sexualEducationDC.resCorrecta

            //funcion que valida cada respuesta ingresada
            fun answerValidate(userResp: Int, resCorrecta: Int) {
                sexualEducationDC.userResp = userResp
                intentos++
                //si la respuesta es correcta
                if (userResp == resCorrecta) {
                    correctas++
                }
                //si las 3 respuestas son correctas
                if (correctas == 3) {
                    correctas = 0
                    intentos = 0
                    contexto.startActivity(Intent(contexto, Correcto::class.java))
                }
                //si los intentos llegan a 3
                if (correctas != 3 && intentos == 3) {
                    correctas = 0
                    intentos = 0
                    contexto.startActivity(Intent(contexto, Incorrecto::class.java))
                }
                //desactiva los botones de la pregunta que se respondio
                boton1.isEnabled = (false)
                boton2.isEnabled = (false)
                boton3.isEnabled = (false)
            }
            //acciones al clickear en los botones de opciones
            boton1.setOnClickListener {
                answerValidate(1, resCorrecta)
            }
            boton2.setOnClickListener {
                answerValidate(2, resCorrecta)
            }
            boton3.setOnClickListener {
                answerValidate(3, resCorrecta)
            }
        }
    }
}