package tn.esprit.nascar.Controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.Model.Event
import tn.esprit.nascar.R

class EventViewAdapter(var dataSource : List<Event>) : RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventItem = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventItem)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.imageEvent.setImageResource(dataSource[position].idImage)
        holder.eventTitle.text = dataSource[position].title
        holder.eventDescription.text = dataSource[position].description
    }
}