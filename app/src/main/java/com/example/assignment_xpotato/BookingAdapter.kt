package com.example.assignment_xpotato

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookingAdapter (private val bookingList: List<BookingView>, private val listener: OnItemClickListener): RecyclerView.Adapter<BookingAdapter.MyViewHolder>(){

    inner class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val checkInDate: TextView = itemView.findViewById(R.id.checkInDate)
        val checkOutDate: TextView = itemView.findViewById(R.id.checkOutDate)

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position : Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.booking_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bookingList.size
    }

    override fun onBindViewHolder(holder: BookingAdapter.MyViewHolder, position: Int) {
        val currentItem = bookingList[position]

        holder.checkInDate.setText(currentItem.checkInDate)
        holder.checkOutDate.setText(currentItem.checkOutDate)
    }
}