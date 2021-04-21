package com.example.assignment_xpotato

//import com.example.assignment_xpotato.MainActivity.Companion.A101
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class BookingDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_detail)
        val database = FirebaseDatabase.getInstance()
        val checkInBtn: Button = findViewById(R.id.bd_CheckInBtn)
        val backBtn = findViewById<Button>(R.id.bd_backBtn)
        val checkOutBtn = findViewById<Button>(R.id.bd_CheckOutBtn)

        var name = findViewById<TextView>(R.id.bd_GuestNameTV)
        var phone = findViewById<TextView>(R.id.bd_GuestPhoneTV)
        var IC = findViewById<TextView>(R.id.bd_GuestICTV)
        var numberOfGuest = findViewById<TextView>(R.id.bd_NumberOfGuestTV)
        var checkInDateTV = findViewById<TextView>(R.id.bd_CheckInDateTV)
        var checkOutDateTV = findViewById<TextView>(R.id.bd_CheckOutDateTV)
        var email = findViewById<TextView>(R.id.bd_GuestEmailTV)
        var status = findViewById<TextView>(R.id.bd_roomStatusTV)
        var bookID = findViewById<TextView>(R.id.bd_bookIDTV)
        var roomNumber = findViewById<TextView>(R.id.bd_roomNumberTV)

        var intent = intent
        val currentBookingID = intent.getStringExtra("bookingID")
        val currentRoomNumber = intent.getStringExtra("roomNumber")
        roomNumber.setText(currentRoomNumber)
        bookID.setText(currentBookingID)
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
                        status.setText(s.child("Status").getValue().toString())
                        bookID.setText(s.key)
                        roomNumber.setText(currentRoomNumber)
                    }
                }






            }
        }
        checkInBtn.setOnClickListener() {

            val intent = Intent(this, Payment::class.java)
            intent.putExtra("roomNumber",currentRoomNumber)
            intent.putExtra("bookingID",currentBookingID)
            startActivity(intent)
        }

        backBtn.setOnClickListener() {
            val intent = Intent(this, Room::class.java)
            startActivity(intent)
        }
        checkOutBtn.setOnClickListener(){
            val intent = Intent(this, Checklist::class.java)
            intent.putExtra("roomNumber",currentRoomNumber)
            intent.putExtra("bookingID",currentBookingID)
            startActivity(intent)
        }
        val q: Query = bookingIDDB.orderByKey().equalTo(currentBookingID)
        q.addValueEventListener(getData)
        q.addListenerForSingleValueEvent(getData)
    }
}