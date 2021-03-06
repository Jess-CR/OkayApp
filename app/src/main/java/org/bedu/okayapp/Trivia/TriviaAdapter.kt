package org.bedu.okayapp.Trivia
//ketzalli
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.bedu.okayapp.R
import org.bedu.okayapp.Trivia.QuestionFragment.Companion.mTriviaViewModel
import room.Trivia

//variables de control
var correctas: Int = 0
var intentos: Int = 0
//private var listaSE: ArrayList<SexualEducationDC>
class TriviaAdapter(
    private var contexto: Context
) : RecyclerView.Adapter<TriviaAdapter.ViewHolder>() {
    private var triviaList = emptyList<Trivia>()

    fun setData(trivia: List<Trivia>) {
        //filtrar aqui: si en la tabla questions, el id es = a la seleccion del usuario
        //entonces se cargaran esas preguntas, una vez que se implemente la base de datos completa
        //se debe pasar como parametro la seleccion que hizo el usuario en subcategorias
      //  this.triviaList = trivia
        this.triviaList = trivia.filter { trivia -> trivia.subcat == Seleccion.subcat}        //este es el filtro, solo implementar cuando la bd este lista (el 2 se cambia por la opcion del usuario)
        notifyDataSetChanged()
    }

    inner class ViewHolder(var view: View, var contexto: Context):RecyclerView.ViewHolder(view){
        //declarar variables
        val pregunta: TextView
        val imagen: ImageView
        val boton1: Button
        val boton2: Button
        val boton3: Button
        var resCorrecta: Int


        //inicializar variables
        init {
            pregunta = itemView.findViewById(R.id.pregunta)
            imagen = itemView.findViewById(R.id.imagen)
            boton1 = itemView.findViewById(R.id.boton1)
            boton2 = itemView.findViewById(R.id.boton2)
            boton3 = itemView.findViewById(R.id.boton3)
            resCorrecta = 0
        }


        fun bind(trivia: Trivia) {
            //asignar los valores a su respectivo componente
            pregunta.text = trivia.triviaQuestion
            Picasso.get().load(trivia.image).
            placeholder(R.drawable.progress).
            into(imagen)
            // imagen.setImageResource(R.drawable.imgprueba)
            boton1.text = trivia.option1
            boton2.text = trivia.option2
            boton3.text = trivia.option3
            resCorrecta = trivia.correctAnswer!!


            //funcion que valida cada respuesta ingresada
            fun answerValidate(userResp: Int, resCorrecta: Int):Int {

                trivia.userAnswer = userResp
                intentos++
                //si la respuesta es correcta
                if (userResp == resCorrecta) {
                    correctas++

                }
                //si las 3 respuestas son correctas
                if (correctas == triviaList.size) {
                    correctas = 0
                    intentos = 0
                    contexto.startActivity(Intent(contexto, Correcto::class.java))
                }
                //si los intentos llegan a 3
                if (correctas != triviaList.size && intentos == 3) {
                    correctas = 0
                    intentos = 0
                    contexto.startActivity(Intent(contexto, Incorrecto::class.java))
                }
                //desactiva los botones de la pregunta que se respondio
                boton1.isEnabled = false
                boton2.isEnabled = false
                boton3.isEnabled = false
                if (userResp == resCorrecta) {
                    return  1}
                    else{
                        return 0
                    }



            }


            //acciones al clickear en los botones de opciones
            lateinit var triviaEdit:Trivia
            boton1.setOnClickListener {
                var id = absoluteAdapterPosition+1
                triviaEdit=triviaList[absoluteAdapterPosition]
                triviaEdit.userAnswer=1
                triviaEdit.ok=answerValidate(1, resCorrecta)
                mTriviaViewModel.updateItem(triviaEdit)
            }
            boton2.setOnClickListener {
                var id = absoluteAdapterPosition+1
                triviaEdit=triviaList[absoluteAdapterPosition]
                triviaEdit.userAnswer=2
                triviaEdit.ok=answerValidate(2, resCorrecta)
                mTriviaViewModel.updateItem(triviaEdit)
            }
            boton3.setOnClickListener {
                var id = absoluteAdapterPosition+1
                triviaEdit=triviaList[absoluteAdapterPosition]
                triviaEdit.userAnswer=3
                triviaEdit.ok=answerValidate(3, resCorrecta)
                mTriviaViewModel.updateItem(triviaEdit)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false),
            contexto
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(triviaList[position])
    }

    override fun getItemCount(): Int {
        return triviaList.size
    }

}