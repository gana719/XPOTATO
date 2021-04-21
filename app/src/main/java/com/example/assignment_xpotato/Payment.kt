package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_xpotato.MainActivity.Companion.database
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val roomNumber = findViewById<TextView>(R.id.p_roomNumberTV)
        var name = findViewById<TextView>(R.id.p_guestNameTV)
        var phone = findViewById<TextView>(R.id.p_guestPhoneTV)
        var IC = findViewById<TextView>(R.id.p_guestICTV)
        var numberOfGuest = findViewById<TextView>(R.id.p_numberOfGuestTV)
        var checkInDateTV = findViewById<TextView>(R.id.p_checkInDateTV)
        var checkOutDateTV = findViewById<TextView>(R.id.p_checkOutDateTV)
        var email = findViewById<TextView>(R.id.p_guestEmailTV)
        var roomChargesTV = findViewById<TextView>(R.id.p_roomChargesTV)
        var roomCharges : Double = 0.00
        val fixedDayFee : Double = 240.0
        val depositFee : Double = 200.0
        var totalFee : Double = 0.00


        val cancelBtn = findViewById<Button>(R.id.p_cancelBtnTV)
        val backBtn = findViewById<Button>(R.id.p_topBackBtn)
        val checkInBtn = findViewById<Button>(R.id.p_checkInBtn)
        val totalFeeTV = findViewById<TextView>(R.id.p_totalFeeTV)



        var intent = intent
        val currentRoomNumber = intent.getStringExtra("roomNumber")
        val currentBookingID = intent.getStringExtra("bookingID")
        roomNumber.setText(currentRoomNumber)
        val bookingIDDB = database.getReference(currentRoomNumber.toString())

        var getData = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.children != null) {
                    for (s in snapshot.children) {

                        name.setText(s.child("Name").getValue().toString())
                        phone.setText(s.child("Phone Number").getValue().toString())
                        IC.setText(s.child("IC").getValue().toString())
                        numberOfGuest.setText(s.child("Number of Guest").getValue().toString())
                        var checkInDate = s.child("dayIn").getValue().toString()+"/"+s.child("monthIn").getValue().toString()+"/"+s.child("yearIn").getValue().toString()
                        var checkOutDate = s.child("dayOut").getValue().toString()+"/"+s.child("monthOut").getValue().toString()+"/"+s.child("yearOut").getValue().toString()
                        checkInDateTV.setText(checkInDate)
                        checkOutDateTV.setText(checkOutDate)
                        email.setText(s.child("Email").getValue().toString())
                        roomCharges = (s.child("totalDayOut").getValue().toString().toDouble()-s.child("totalDayIn").getValue().toString().toDouble()+1)*fixedDayFee
                        roomChargesTV.setText(roomCharges.toString())
                        totalFee = roomCharges+depositFee
                        totalFeeTV.setText(totalFee.toString())
                    }
                }






            }
        }

        val q: Query = bookingIDDB.orderByKey().equalTo(currentBookingID)
        q.addValueEventListener(getData)
        q.addListenerForSingleValueEvent(getData)

        cancelBtn.setOnClickListener(){
            val intent = Intent (this, BookingDetail::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener(){
            val intent = Intent (this, BookingDetail::class.java)
            startActivity(intent)
        }

        checkInBtn.setOnClickListener(){
            Toast.makeText(this, "Successfully booked in.", Toast.LENGTH_SHORT).show()
            bookingIDDB.child(currentBookingID.toString()).child("Status").setValue(1)
            val intent = Intent (this, BookingDetail::class.java)
            startActivity(intent)
        }
    }



}