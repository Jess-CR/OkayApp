package org.bedu.okayapp.Trivia
//ketzalli
//permite escoger si ir al test o si ir a la zona de estudio (youtube)
//se debe cambiar para mostrar el contenido en base al tema escogido
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.bedu.okayapp.databinding.ActivitySeleccionBinding

class Seleccion : AppCompatActivity() {
    companion object {
        var subcat: String = ""
        val map = mapOf(
            "Métodos anticonceptivos" to "Existen diferentes tipos de métodos anticonceptivos, lo recomendable es hablar con un especialista de la salud para que te asesore y te aclare tus dudas.",
            "Biología reproductiva" to "Disfruta de tu salud sexual, pero siempre ten en cuenta tu proyecto de vida y cómo un embarazado no deseado podría impactarte.",
            "ETS" to "Recuerda que usar métodos anticonceptivos no es exclusivamente para evitar un embarazo, sino también para prevenir enfermedades de transmisión sexual.",
            "Consentimiento " to "El consentimiento se da de manera libre, informada, y puedes cambiar de opinión. La actividad sexual sin consentimiento es una violación o agresión sexual.",
            "Ahorro" to "Existen muchos recursos para aprender en línea. Un recurso útil por su facilidad de lenguaje es el libro del Pequeño Cerdo Capitalista de Sofía Macías",
            "Crédito" to "Existen cursos gratuitos en línea sobre Educación Financiera los cuales proporciona la CONDUSEF ",
            "Inversión y Seguros" to "Cuando se realiza una inversión o se adquiere un seguro, es importante hacer una investigación de las diferentes opciones y evaluarla entre las ventajas y desventajas. ",
            "Buró de Crédito" to "Cualquier persona que haga uso de un crédito se encontrará en el buró de crédito. Este informa tu historial crediticio y te brinda una 'calificación'. ",
            "Entrevistas" to "Aunque las entrevistas pueden llegar a ser un poco aterradoras, una de las recomendaciones más populares es practicar frente al espejo y tener confianza en uno mismo.",
            "CV" to "No existe una manera correcta de escribir un CV (Curriculum Vitae) pero una recomendación es que puedas mostrarle a otras personas tu CV para que le den una revisada y te den su retroalimentación. Existen muchas plantillas y páginas web que hacen recomendaciones al respecto. ",
            "Habilidades sociales" to "Las habilidades sociales, como cualquier otra habilidad se pueden desarrollar. Dado que vivimos en sociedad, es importante ser asertivos, empático y sensibles ante nuestro entorno. ",
            "Reciclaje" to "Separar los residuos y llevarlos a centros para su reciclaje ayuda mucho al medio ambiente. Aunque recuerda que ayuda más procurar generar la menor cantidad de desechos. ",
            "Energías Renovables" to "La reducción es de las mejores estrategias para cuidar el medio ambiente. Es importante consumir de manera consciente. Recuerda que menos es más.",
            "Mental" to "Sigue existiendo mucho tabú alrededor del cuidado de la salud mental, pero así como iriás al médico cuando te sientes mal por un resfriado, es fundamental que también prestes atención a como algunas situaciones impactan otras áreas de tu vida. ",
            "Alimenticia" to "\"No todos requieren de consumir la misma cantidad de proteína o calorías. Sin embargo, es importante que tengas una dieta balanceada y visites a tu nutriólog@",
            "Física" to "El hacer ejercicio de manera constante ayuda a nuestra salud física, emocional y mental. Procura al menos realizar 30 minutos al día ejercicio"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySeleccionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()



        subcat = intent.getStringExtra("subcat").toString()

        // if(intent.getStringExtra("temaP").toString().length>1){
        //  subcat = intent.getStringExtra("temaP").toString()

        //    }
        //Se creahsea con consentiemiento y otros sub temas arreglar MapOf
        binding.textView14.text = map.getValue(subcat)
        binding.textView12.text = subcat


        binding.paraEstudio.setOnClickListener {
            val intent = Intent(this,Estudio::class.java)
            startActivity(intent)
        }

        binding.paraTest.setOnClickListener {
            val intent = Intent(this, BaseQuestion::class.java)

            startActivity(intent)
        }

    }

}