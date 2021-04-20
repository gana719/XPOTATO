package com.example.assignment_xpotato

//import com.example.assignment_xpotato.MainActivity.Companion.A101
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
         val A101 = database.getReference("A101")
        val checkInBtn: Button = findViewById(R.id.bd_CheckInBtn)

        var name = findViewById<TextView>(R.id.bd_GuestNameTV)
        var phone = findViewById<TextView>(R.id.bd_GuestPhoneTV)
        var IC = findViewById<TextView>(R.id.bd_GuestICTV)
        var numberOfGuest = findViewById<TextView>(R.id.bd_NumberOfGuestTV)
        var checkInDate = findViewById<TextView>(R.id.bd_CheckInDateTV)
        var checkOutDate = findViewById<TextView>(R.id.bd_CheckOutDateTV)
        var email = findViewById<TextView>(R.id.bd_GuestEmailTV)
        var status = findViewById<TextView>(R.id.bd_roomStatusTV)


        var getData = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}


            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.children != null) {

                    name.setText(snapshot.child("Name").getValue().toString())
                    phone.setText(snapshot.child("Phone Number").getValue().toString())
                    IC.setText(snapshot.child("IC").getValue().toString())
                    numberOfGuest.setText(snapshot.child("Number of Guest").getValue().toString())
                    checkInDate.setText(snapshot.child("Check-In Date").getValue().toString())
                    checkOutDate.setText(snapshot.child("Check-Out Date").getValue().toString())
                    email.setText(snapshot.child("Email").getValue().toString())
                    status.setText(snapshot.child("Status").getValue().toString())


                }

            }
        }
        checkInBtn.setOnClickListener() {
            val q: Query = A101.orderByChild("Name").equalTo("101")
            q.addValueEventListener(getData)
            q.addListenerForSingleValueEvent(getData)
        }
    }
}