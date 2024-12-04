package com.example.aplicacion2

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val events: List<Evento>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_form, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = events.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageEvent: ImageView = itemView.findViewById(R.id.imageEvent)
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textDescription: TextView = itemView.findViewById(R.id.textDescription)
        private val textPrice: TextView = itemView.findViewById(R.id.textPrice)

        fun bind(event: Evento) {
            textName.text = event.name
            textDescription.text = event.description
            textPrice.text = event.price
            if (event.imageUri != null) {
                imageEvent.setImageURI(Uri.parse(event.imageUri))
            } else {
                imageEvent.setImageResource(R.drawable.ic_placeholder1) // Default image
            }
        }
    }
}