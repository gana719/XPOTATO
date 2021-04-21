package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_xpotato.MainActivity.Companion.database
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class RoomFragment : DialogFragment(),BookingAdapter.OnItemClickListener{
    var f_room : String = ""

    val c= Calendar.getInstance()
    val year= c.get(Calendar.YEAR)

    val month = c.get(Calendar.MONTH)+1
    val day = c.get(Calendar.DAY_OF_MONTH)
    var totalDayNow = day+month*30+year*365.25



    private val arrBooking = ArrayList<BookingView>()
    private val adapter = BookingAdapter(arrBooking, this)
    override fun onCreateView
            (inflater: LayoutInflater
             , container: ViewGroup?,
             savedInstanceState: Bundle?
    ): View? {

        var checkInDate : String
        var checkOutDate : String

        val bundle = arguments
        f_room = bundle!!.getString("RoomNumber", "")

        val roomNumberDB = database.getReference(f_room.toString())


        var getData = object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            //            override fun onDataChange(snapshot: DataSnapshot) {
//                var sbName = StringBuilder();
//
//                for(s in snapshot.children){
//                        val studentName = s.child("Name").getValue()
//                        sbName.append("${studentName} \n")
//                }
//                findViewById<TextView>(R.id.output).setText(sbName)
//            }
            override fun onDataChange(snapshot: DataSnapshot) {

                arrBooking.clear()
                if(snapshot.children != null) {

                    for (s in snapshot.children) {
                        checkInDate = s.child("dayIn").getValue().toString()+"/"+s.child("monthIn").getValue().toString()+"/"+s.child("yearIn").getValue().toString()
                        checkOutDate = s.child("dayOut").getValue().toString()+"/"+s.child("monthOut").getValue().toString()+"/"+s.child("yearOut").getValue().toString()

                        arrBooking += BookingView(
                                checkInDate,
                                checkOutDate,
                                s.key,
                                s.child("Status").getValue().toString().toInt()
                        )
                    }
                }

                val cycleView = view?.findViewById<RecyclerView>(R.id.fr_recycleView)
                cycleView?.adapter = adapter
                cycleView?.layoutManager = LinearLayoutManager(context)
                cycleView?.setHasFixedSize(true)
            }
        }

        val q : Query = roomNumberDB.orderByChild("totalDayOut").startAfter(totalDayNow)


        q.addValueEventListener(getData)
        q.addListenerForSingleValueEvent(getData)

        var rootView: View = inflater.inflate(R.layout.fragment_room, container, false)



        val roomNumberFragment = rootView.findViewById<TextView>(R.id.rf_roomNumber)

        roomNumberFragment.text = f_room

        val rfBackBtn = rootView.findViewById<Button>(R.id.rf_backBtn)
        rfBackBtn.setOnClickListener{
            dismiss()
        }

        val btnAdd = rootView.findViewById<Button>(R.id.rf_addBtn)
        btnAdd.setOnClickListener{
            val intent = Intent (this.context, BookingCheckIn::class.java)
            intent.putExtra("roomNumber",f_room)
            startActivity(intent)
        }

        return rootView

    }
    override fun onItemClick(position: Int) {

        val clickedItem = arrBooking[position]
        val intent = Intent (this.context, BookingDetail::class.java)
        intent.putExtra("bookingID",clickedItem.bookingID)
        intent.putExtra("roomNumber",f_room)
        startActivity(intent)

    }
}