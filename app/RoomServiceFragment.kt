package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class RoomServiceFragment : DialogFragment(){

    override fun onCreateView
            (inflater: LayoutInflater
             , container: ViewGroup?,
             savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_room_service, container, false)

        val bundle = arguments
        val f_room = bundle!!.getString("RoomNumber", "")

        val roomNumberFragment = rootView.findViewById<TextView>(R.id.rf_roomNumber)

        roomNumberFragment.text = f_room

        val rsfBackBtn = rootView.findViewById<Button>(R.id.rsf_backBtn)
        rsfBackBtn.setOnClickListener{
            dismiss()
        }

        val rsfRoomCleaningBtn = rootView.findViewById<Button>(R.id.rsf_roomCleaningBtn)
        rsfRoomCleaningBtn.setOnClickListener{
            val intent = Intent (this.context, MainActivity::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }
        val rsfFoodAndBeverageBtn = rootView.findViewById<Button>(R.id.rsf_foodAndBeverageBtn)
        rsfFoodAndBeverageBtn.setOnClickListener{
            val intent = Intent (this.context, MainActivity::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }
        val rsfRefillItemBtn = rootView.findViewById<Button>(R.id.rsf_refillItemBtn)
        rsfRefillItemBtn.setOnClickListener{
            val intent = Intent (this.context, MainActivity::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }

        return rootView

    }
}