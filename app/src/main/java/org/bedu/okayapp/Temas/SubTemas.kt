package org.bedu.okayapp.Temas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.bedu.okayapp.R

class SubTemas (private var listaST:ArrayList<SubTemasDC>,private val onSubTemaClickListener:OnSubTemaClickListener): RecyclerView.Adapter<SubTemas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_subtema, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaST[position])
        holder.itemView.setOnClickListener{
            onSubTemaClickListener.onSubTemaItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return listaST.size
    }

    class ViewHolder(private var view: View) :
        RecyclerView.ViewHolder(view) {
        val titleSTheme: TextView
        val imageSTheme: ImageView
        val progressSTheme: ProgressBar

        init {
            titleSTheme = view.findViewById(R.id.titleSTheme)

            imageSTheme = view.findViewById(R.id.imageSTheme)
            progressSTheme = view.findViewById(R.id.progressSTheme)
            progressSTheme.progress = 0
        }

        fun bind(SubTemasDC: SubTemasDC) {
            titleSTheme.text = SubTemasDC.title
            Picasso.get().load(SubTemasDC.imageId).into(imageSTheme)
            // imageSTheme.setImageResource(SubTemasDC.imageId)
            progressSTheme.progress = SubTemasDC.percentage
        }
    }
}
