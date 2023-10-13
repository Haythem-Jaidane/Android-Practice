package tn.esprit.nascar.Controller

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.R

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageEvent: ImageView = itemView.findViewById(R.id.eventImage)
    var eventTitle: TextView = itemView.findViewById(R.id.eventTitle)
    var eventDescription: TextView = itemView.findViewById(R.id.eventDescription)
}