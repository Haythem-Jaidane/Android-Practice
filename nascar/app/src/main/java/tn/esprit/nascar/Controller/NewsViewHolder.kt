package tn.esprit.nascar.Controller

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.R

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.newsImage)
    val title: TextView = itemView.findViewById(R.id.newsTitle)
    val description: TextView = itemView.findViewById(R.id.newsDescription)
}