/*package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class RoomServiceFragment : DialogFragment(){

    override fun onCreateView
            (inflater: LayoutInflater
             , container: ViewGroup?,
             savedInstanceState: Bundle?
            ): View? {

        var rootView: View = inflater.inflate(R.layout.fragment_room, container, false)
        val roomCleaningBtn = rootView.findViewById<Button>(R.id.rsf_roomCleaningBtn)
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

        roomCleaningBtn.setOnClickListener{
            val intent = Intent (this.context, MainActivity::class.java)
            Toast.makeText(this.context, "EAT SHIT $f_room is booked to be cleaned.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        return rootView

    }
}*/

package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class RoomServiceFragment : DialogFragment(){



    override fun onCreateView
            (inflater: LayoutInflater
             , container: ViewGroup?,
             savedInstanceState: Bundle?
            ): View? {
        val TAG = " RSF"
        Log.d(TAG,"INNED")
        var rootView: View = inflater.inflate(R.layout.fragment_room_service, container, false)

        val bundle = arguments
        val f_room = bundle!!.getString("RoomNumber", "")

        val roomNumberFragment = rootView.findViewById<TextView>(R.id.rsf_roomNumber)

        roomNumberFragment.text = f_room

        val rsfBackBtn = rootView.findViewById<Button>(R.id.rsf_backBtn)
        rsfBackBtn.setOnClickListener{
            dismiss()
        }

        val roomCleaningBtn = rootView.findViewById<Button>(R.id.rsf_roomCleaningBtn)
        roomCleaningBtn.setOnClickListener{
            Toast.makeText(this.context, "$f_room is booked to be cleaned.", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        val refillItemBtn = rootView.findViewById<Button>(R.id.rsf_refillItemBtn)
        refillItemBtn.setOnClickListener{
            val intent = Intent (this.context, refill_item::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }


        val foodBeverageBtn = rootView.findViewById<Button>(R.id.rsf_foodAndBeverageBtn)
        foodBeverageBtn.setOnClickListener{
            val intent = Intent (this.context, food_beverage::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }


        return rootView

    }
}