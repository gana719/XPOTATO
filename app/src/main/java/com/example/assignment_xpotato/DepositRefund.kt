package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class DepositRefund : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit_refund)



        var intent = intent
        var totalCharge : Double = 0.00
        val deposit : Double = 200.00
        var extraPayment : Double = 0.00
        var depositRefund : Double = 0.00
        val currentRoomNumber = intent.getStringExtra("roomNumber")
        val currentBookingID = intent.getStringExtra("bookingID")
        val currentMissingFine = intent.getDoubleExtra("totalMissingFine",0.00)
        val currentBrokenFine = intent.getDoubleExtra("totalBrokenFine",0.00)
        var name = findViewById<TextView>(R.id.dr_guestNameTV)
        var phone = findViewById<TextView>(R.id.dr_guestPhoneTV)
        var IC = findViewById<TextView>(R.id.dr_guestICTV)
        var email = findViewById<TextView>(R.id.dr_guestEmailTV)
        val brokenItemChargeTV = findViewById<TextView>(R.id.dr_brokenItemChargeTV)
        val missingItemChargeTV = findViewById<TextView>(R.id.dr_missingItemChargeTV)
        val totalChargeTV = findViewById<TextView>(R.id.dr_totalChargeTV)
        val extraPaymentTV = findViewById<TextView>(R.id.dr_extraPaymentTV)
        val depositRefundTV = findViewById<TextView>(R.id.dr_depositRefundTV)

        val roomNumberDB = MainActivity.database.getReference(currentRoomNumber.toString())

        val topBackBtn = findViewById<Button>(R.id.dr_topBackBtn)
        val backBtn = findViewById<Button>(R.id.dr_backBtn)
        val confirmBtn = findViewById<Button>(R.id.dr_confirmBtn)

        totalCharge = currentBrokenFine+currentMissingFine
        missingItemChargeTV.setText(currentMissingFine.toString())
        brokenItemChargeTV.setText(currentBrokenFine.toString())
        totalChargeTV.setText(totalCharge.toString())
        extraPayment=totalCharge-deposit

        if(extraPayment<=0){
            depositRefund = extraPayment*-1
            depositRefundTV.setText(depositRefund.toString())
            extraPaymentTV.setText("0.0")

        }
        else {
            extraPaymentTV.setText(extraPayment.toString())
            depositRefundTV.setText("0.0")
        }



        var getData = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {}


            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.children != null) {
                    for (s in snapshot.children) {

                        name.setText(s.child("Name").getValue().toString())
                        phone.setText(s.child("Phone Number").getValue().toString())
                        IC.setText(s.child("IC").getValue().toString())
                        email.setText(s.child("Email").getValue().toString())
                    }
                }






            }
        }


        val q : Query = roomNumberDB.orderByKey().equalTo(currentBookingID)

        q.addValueEventListener(getData)
        q.addListenerForSingleValueEvent(getData)

        confirmBtn.setOnClickListener(){
            Toast.makeText(this, "Successfully checked out!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        topBackBtn.setOnClickListener(){
            val intent = Intent(this, Checklist::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener(){
            val intent = Intent(this, Checklist::class.java)
            startActivity(intent)
        }

    }
}