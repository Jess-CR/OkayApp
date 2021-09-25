package org.bedu.okayapp
/*
ketzalli
se encarga de hacer funcionar los recyclerview de las preguntas

pendientes:
implementar la seleccion aleatoria de preguntas (sin repetirse)
implementar la base de datos
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import room.Trivia

//variables de control
var correctas: Int = 0
var intentos: Int = 0

class TriviaAdapter() : RecyclerView.Adapter<TriviaAdapter.ViewHolder>() {
    private var triviaList = emptyList<Trivia>()
    fun setData(trivia: List<Trivia>){
        this.triviaList = trivia
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(triviaList[position])
    }

    override fun getItemCount(): Int {
        return triviaList.size
    }

    class ViewHolder(private var view: View) :
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


        fun bind(trivia: Trivia) {
            //asignar los valores a su respectivo componente
            pregunta.text = trivia.triviaQuestion
            imagen.setImageResource(R.drawable.imgprueba)
            boton1.text = trivia.option1
            boton2.text = trivia.option2
            boton3.text = trivia.option3
            resCorrecta = trivia.correctAnswer!!

        }
    }
}