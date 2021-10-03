package org.bedu.okayapp.Temas

import org.bedu.okayapp.Animations.ProgressBarAnimation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.bedu.okayapp.Inicio.LogIn
import org.bedu.okayapp.Progreso.Progress
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityCategoriesBinding
import kotlin.math.sign


class categories : AppCompatActivity() {

    private lateinit var listaCategorias: ListView
    private lateinit var binding: ActivityCategoriesBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        auth=FirebaseAuth.getInstance()
        setContentView(binding.root)
        val arrayAdapter: ArrayAdapter<*>
       // val servicio1 = resources.getStringArray(R.array.Categorias)

        //arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, servicio1)
       // listaCategorias.adapter = arrayAdapter

        val progressBar = ProgressBarAnimation(binding.CategoriesProgressBar,binding.progressPercentage,binding.progressPercentage)

        progressBar.initProgressBar()

        binding.categoriasButtonSalir.setOnClickListener {
            signOut()
        }

        val imageId = intArrayOf(
            R.drawable.sexual_education, R.drawable.sexual_education, R.drawable.sexual_education, R.drawable.sexual_education, R.drawable.sexual_education,
            R.drawable.sexual_education
        )
        val name = arrayOf(
            "Salud sexual y reproductiva",
            "Finanzas",
            "Vida laboral",
            "Medio ambiente",
            "Salud",
            "Relaciones humanas"
        )
        val phoneNo = arrayOf(
            "7656610000", "9999043232", "7834354323", "9876543211", "5434432343",
            "9439043232"
        )

        val userArrayList: ArrayList<Categorias> = ArrayList()
        for (i in imageId.indices) {
            val user = Categorias(
                name[i],imageId[i]
            )
            userArrayList.add(user)
        }
        val listAdapter = ListAdapter(this, userArrayList)
        binding.listview.setAdapter(listAdapter)
        binding.listview.setClickable(true)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", name[position])
            i.putExtra("seccion", phoneNo[position])
            i.putExtra("imageid", imageId[position])
            startActivity(i)
        }
    }

    fun progreso(view: View) {
        startActivity(Intent(this, Progress::class.java))
    }

    private fun signOut(){
        Firebase.auth.signOut()
        val intent = Intent(this,LogIn::class.java)
        startActivity(intent)
    }
}