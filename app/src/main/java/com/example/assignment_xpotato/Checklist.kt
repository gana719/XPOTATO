package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class Checklist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)

        var intent = intent
        val currentRoomNumber = intent.getStringExtra("roomNumber")
        val currentBookingID = intent.getStringExtra("bookingID")
        val nextBtn = findViewById<Button>(R.id.c_nextBtn)

        var totalMissingFine : Double = 0.00
        var totalBrokenFine : Double = 0.00
        totalMissingFine=0.0
        totalBrokenFine=0.0
        val towelBox = findViewById<CheckBox>(R.id.c_towelBtn)
        val pillowBox = findViewById<CheckBox>(R.id.c_pillowBtn)
        val hangerBox = findViewById<CheckBox>(R.id.c_hangerBtn)
        val bathrobeBox = findViewById<CheckBox>(R.id.c_bathrobeBtn)
        val cupBox = findViewById<CheckBox>(R.id.c_cupBtn)
        val kettleBox = findViewById<CheckBox>(R.id.c_kettleBtn)
        val lampBox = findViewById<CheckBox>(R.id.c_lampBtn)
        val sofaBox = findViewById<CheckBox>(R.id.c_sofaBtn)
        val bedBox = findViewById<CheckBox>(R.id.c_bedBtn)
        val cabinetBox = findViewById<CheckBox>(R.id.c_cabinetBtn)
        val backBtn = findViewById<Button>(R.id.c_backBtn)
        val topBackBtn = findViewById<Button>(R.id.c_topBackBtn)

        nextBtn.setOnClickListener(){
            if(towelBox.isChecked==true){
                totalMissingFine+=15.00
            }

            if(pillowBox.isChecked){
                totalMissingFine+=20.00
            }

            if(hangerBox.isChecked){
                totalMissingFine+=15.00
            }

            if(bathrobeBox.isChecked){
                totalMissingFine+=15.00
            }

            if(cupBox.isChecked){
                totalMissingFine+=10.00
            }

            if(kettleBox.isChecked){
                totalMissingFine+=80.00
            }

            if(lampBox.isChecked){
                totalBrokenFine+=30.00
            }

            if(sofaBox.isChecked){
                totalBrokenFine+=300.00
            }

            if(bedBox.isChecked){
                totalBrokenFine+=500.00
            }

            if(cabinetBox.isChecked){
                totalBrokenFine+=400.00
            }

             intent = Intent(this, DepositRefund::class.java)
            intent.putExtra("roomNumber",currentRoomNumber)
            intent.putExtra("bookingID",currentBookingID)
            intent.putExtra("totalBrokenFine",totalBrokenFine)
            intent.putExtra("totalMissingFine",totalMissingFine)
            startActivity(intent)
        }

        backBtn.setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        topBackBtn.setOnClickListener(){
            intent = Intent(this, BookingDetail::class.java)
            intent.putExtra("roomNumber",currentRoomNumber)
            intent.putExtra("bookingID",currentBookingID)
            startActivity(intent)
        }


    }
}