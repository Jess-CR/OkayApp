package Trivia
//ketzalli
//version de prueba de base de datos
//no implementada
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectobedufase3_prueba1.room.DatabaseTrivia
import com.example.proyectobedufase3_prueba1.room.SexualEducation
import com.example.proyectobedufase3_prueba2.R
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.properties.Delegates

class TriviaAdapter : RecyclerView.Adapter<TriviaAdapter.ViewHolder>() {

    //obtener id aleatorio de las preguntas, no pueden ser iguales
    //el 5 representa el maximo de preguntas que tiene la BD
    //val randomQuestion = (1..5).random()

    private lateinit var itemQuestion: TextView
//        var itemImage: ImageView
    private lateinit var itemOpc1: Button
    private lateinit var itemOpc2: Button
    private lateinit var itemOpc3: Button
    private var ResCorrecta by Delegates.notNull<Int>()

    val questions=arrayOf(
        "¿Cuáles de estos son tus derechos?",
        "Tu amiga está viviendo una relación de pareja abusiva… ¿Qué le aconsejas?",
        "Deseas tener relaciones sexuales con tu pareja, pero te ha dicho que no. ¿Qué harías?")
    //val images= intArrayOf(R.drawable.imgprueba,R.drawable.imgprueba,R.drawable.imgprueba)
    val options1=arrayOf(
        "A vivir libres de discriminación basada en mi sexo, sexualidad o género",
        "Que no sea tonta y que termine esa relación",
        "Tratar de convencer por todos los medios a tu pareja para que te acepte. Si te ama lo debería hacer")
    val options2=arrayOf(
        "A decidir si tener o no hijos y cómo y cuándo tenerlos",
        "Que trate de arreglar los problemas con su pareja",
        "Respetar su decisión y hablar abiertamente sobre el tema para llegar a un acuerdo con el que ambos estén cómodos")
    val options3=arrayOf(
        "Todas las anteriores",
        "Que busque ayuda familiar y orientación profesional (ONG’s, grupos de apoyo) para salir de esa relación",
        "Engañar a mi pareja con otra persona que sí me dé lo que deseo")
    val resCorrecta=arrayOf(
        3,
        3,
        2
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v=LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        itemQuestion.text=questions[i]
        //viewHolder.itemImage.setImageResource(images[i])
        itemOpc1.text=options1[i]
        itemOpc2.text=options2[i]
        itemOpc3.text=options3[i]
        ResCorrecta=resCorrecta[i]
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemQuestion = itemView.findViewById(R.id.pregunta)
//            itemImage = itemView.findViewById(R.id.imagen)
            itemOpc1 = itemView.findViewById(R.id.boton1)
            itemOpc2 = itemView.findViewById(R.id.boton2)
            itemOpc3 = itemView.findViewById(R.id.boton3)
            //ResCorrecta=0
        }
    }

}

/*
//prueba
class TriviaAdapter(preguntasArray: MutableList<SexualEducation>, listener: Any?) : Fragment() {

    private lateinit var itemQuestion: TextView

    //        var itemImage: ImageView
    private lateinit var itemOpc1: Button
    private lateinit var itemOpc2: Button
    private lateinit var itemOpc3: Button
    private lateinit var act: Button
    private var ResCorrecta:Int=0

    //para la respuesta del usuario
    var userOpt:Int=0

    val questions =
        "¿Cuáles de estos son tus derechos?"*/
/*,
        "Tu amiga está viviendo una relación de pareja abusiva… ¿Qué le aconsejas?",
        "Deseas tener relaciones sexuales con tu pareja, pero te ha dicho que no. ¿Qué harías?"*//*



    //val images= intArrayOf(R.drawable.imgprueba,R.drawable.imgprueba,R.drawable.imgprueba)
    val options1 =
        "A vivir libres de discriminación basada en mi sexo, sexualidad o género"*/
/*,
        "Que no sea tonta y que termine esa relación",
        "Tratar de convencer por todos los medios a tu pareja para que te acepte. Si te ama lo debería hacer"*//*


    val options2 =
        "A decidir si tener o no hijos y cómo y cuándo tenerlos"*/
/*,
        "Que trate de arreglar los problemas con su pareja",
        "Respetar su decisión y hablar abiertamente sobre el tema para llegar a un acuerdo con el que ambos estén cómodos"*//*


    val options3 =
        "Todas las anteriores"*/
/*,
        "Que busque ayuda familiar y orientación profesional (ONG’s, grupos de apoyo) para salir de esa relación",
        "Engañar a mi pareja con otra persona que sí me dé lo que deseo"*//*


    val resCorrecta =
        3*/
/*,
        3,
        2*//*



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.card_layout, container, false)


        itemQuestion = view.findViewById(R.id.pregunta)
//            itemImage = itemView.findViewById(R.id.imagen)
        itemOpc1 = view.findViewById(R.id.boton1)
        itemOpc2 = view.findViewById(R.id.boton2)
        itemOpc3 = view.findViewById(R.id.boton3)
        act = view.findViewById(R.id.addButton)
        //ResCorrecta=0

        itemOpc1.setOnClickListener{
            userOpt=1
        }
        itemOpc2.setOnClickListener{
            userOpt=2
        }
        itemOpc3.setOnClickListener{
            userOpt=3
        }

        //se debe ejecutar automaticamente al comienzo de la activity
        act.setOnClickListener {
            addSE()
        }
        return view
    }

    private fun addSE(){

        val se=SexualEducation(
            pregunta = questions,
            //viewHolder.itemImage.setImageResource(images[i])
            opcion1 = options1,
            opcion2 = options2,
            opcion3 = options3,
            respCorrecta = resCorrecta,
            respUser = userOpt
        )

        val executor:ExecutorService=Executors.newSingleThreadExecutor()

        executor.execute(Runnable {
            DatabaseTrivia
                .getInstance(requireContext())
                ?.triviaDao()
                ?.insertSE(se)

            */
/*Handler(Looper.getMainLooper()).post(Runnable {
                findNavController().navigate(
                    R.id.action_TriviaAdapter_to_MainActivity
                )
            })*//*

        })
    }
}*/
