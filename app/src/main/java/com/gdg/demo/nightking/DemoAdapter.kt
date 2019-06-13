package com.gdg.demo.nightking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DemoAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<DemoAdapter.DemoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var demos = emptyList<Demo>()

    inner class DemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val demoTime: TextView = itemView.findViewById(R.id.demo_time_text_view)
        val demoTitle: TextView = itemView.findViewById(R.id.demo_title_text_view)
        val demoVenue: TextView = itemView.findViewById(R.id.demo_venue_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        val itemView = inflater.inflate(R.layout.list_item_layout, parent, false)
        return DemoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        val current = demos[position]
        holder.demoTime.text = current.time
        holder.demoTitle.text = current.title
        holder.demoVenue.text = current.venue
    }

    internal fun setDemos(accounts: List<Demo>) {
        this.demos = accounts
        notifyDataSetChanged()
    }

    override fun getItemCount() = demos.size
}
