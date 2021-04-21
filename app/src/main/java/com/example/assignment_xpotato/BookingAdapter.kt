package com.example.assignment_xpotato

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookingAdapter (private val bookingList: List<BookingView>, private val listener: OnItemClickListener): RecyclerView.Adapter<BookingAdapter.MyViewHolder>(){
    var status : Int = 0
    inner class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val checkInDate: TextView = itemView.findViewById(R.id.checkInDate)
        val checkOutDate: TextView = itemView.findViewById(R.id.checkOutDate)
        val bookingID : TextView = itemView.findViewById(R.id.bl_bookingID)

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

        if(status == 1){
            itemView.setBackgroundColor(Color.parseColor("#029A30"));
        }else{ itemView.setBackgroundColor(Color.parseColor("#FF2818"));}

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bookingList.size
    }

    override fun onBindViewHolder(holder: BookingAdapter.MyViewHolder, position: Int) {
        val currentItem = bookingList[position]

        holder.checkInDate.setText(currentItem.checkInDate)
        holder.checkOutDate.setText(currentItem.checkOutDate)
        status = currentItem.status.toString().toInt()
        holder.bookingID.setText(currentItem.bookingID)
    }
}