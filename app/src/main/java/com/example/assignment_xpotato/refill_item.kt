package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class   refill_item : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refill_item)

        var intent = intent

        val roomNumber = intent.getStringExtra("roomNumber")
        findViewById<TextView>(R.id.ri_roomNumberTV).setText(roomNumber)

        val cancelBtn = findViewById<Button>(R.id.ri_cancelBtn)
        cancelBtn.setOnClickListener(){
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        val backBtn = findViewById<Button>(R.id.ri_backBtn)
        backBtn.setOnClickListener(){
            val intent = Intent (this, RoomService::class.java)
            startActivity(intent)
        }

        val confirmBtn = findViewById<Button>(R.id.ri_confirmBtn)
        confirmBtn.setOnClickListener(){
            val intent = Intent (this, RoomService::class.java)
            Toast.makeText(this, "$roomNumber is going to be refilled.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}