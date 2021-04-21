package com.example.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class RoomFragment : DialogFragment(){

    override fun onCreateView
            (inflater: LayoutInflater
             , container: ViewGroup?,
             savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_room, container, false)

        val bundle = arguments
        val f_room = bundle!!.getString("RoomNumber", "")

        val roomNumberFragment = rootView.findViewById<TextView>(R.id.rf_roomNumber)

        roomNumberFragment.text = f_room

        val rfBackBtn = rootView.findViewById<Button>(R.id.rf_backBtn)
        rfBackBtn.setOnClickListener{
            dismiss()
        }

        val btnAdd = rootView.findViewById<Button>(R.id.rf_addBtn)
        btnAdd.setOnClickListener{
            val intent = Intent (this.context, MainActivity::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }

        return rootView

    }
}