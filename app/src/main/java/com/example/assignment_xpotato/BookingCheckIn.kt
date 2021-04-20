package com.example.assignment_xpotato

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_xpotato.MainActivity.Companion.bookingID
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class BookingCheckIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val database = FirebaseDatabase.getInstance()
        val A101 = database.getReference("A101")



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_checkin)

        val bookingInBtn = findViewById<Button>(R.id.bc_bookingBtn)
        val booking_checkinBtn = findViewById<Button>(R.id.bc_booking_CheckInBtn)

        val fiosdgjfd : String = "100"
        var fidj : Int = fiosdgjfd.toInt()+1
        var roomNumberTv = findViewById<TextView>(R.id.bc_room_numberTV)

        roomNumberTv.setText(fidj.toString())

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val checkInCalendarTV = findViewById<TextView>(R.id.bc_check_in_calendarEditText)
        val checkOutCalendarTV = findViewById<TextView>(R.id.bc_check_out_calendarEditText)

        var checkInDate : String
        var checkOutDate : String

        checkInCalendarTV.setOnClickListener {


            val c= Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            var dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear,mMonth , mDay ->
                val mmMonth = mMonth+1
                val date = "$mDay/$mmMonth/$mYear"
                checkInCalendarTV.setText(date)
                checkInDate = (date)
            },year,month,day)

            dpd.show()

        }

        checkOutCalendarTV.setOnClickListener {


            val c= Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            var dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear,mMonth , mDay ->
                val mmMonth = mMonth+1
                val date = "$mDay/$mmMonth/$mYear"
                checkOutCalendarTV.setText(date)
                checkOutDate = date
            },year,month,day)
            dpd.show()

        }
        bookingInBtn.setOnClickListener(){
            //status 0 = booked, 1 = checked in
            val status : Int = 0
            val name: String = findViewById<TextView>(R.id.bc_guest_name_EditText).text.toString()
            val phone: String = findViewById<TextView>(R.id.bc_guest_phoneNumber_EditText).text.toString()
            val IC : String = findViewById<TextView>(R.id.bc_guest_ICNumber_EditText).text.toString()
            val numberOfGuest : String = findViewById<TextView>(R.id.bc_guest_number_EditText).text.toString()
            val email = findViewById<TextView>(R.id.bc_guest_Email_EditText).text.toString()
            val checkInDate : String = checkInCalendarTV.text.toString()
            val checkOutDate : String = checkOutCalendarTV.text.toString()

            bookingID++

            A101.child(bookingID.toString()).child("Name").setValue(name)
            A101.child(bookingID.toString()).child("Phone Number").setValue(phone)
            A101.child(bookingID.toString()).child("IC").setValue(IC)
            A101.child(bookingID.toString()).child("Number of Guest").setValue(numberOfGuest)
            A101.child(bookingID.toString()).child("Check-In Date").setValue(checkInDate)
            A101.child(bookingID.toString()).child("Check-Out Date").setValue(checkOutDate)
            A101.child(bookingID.toString()).child("Email").setValue(email)
            A101.child(bookingID.toString()).child("Status").setValue(status)



        }


    }


}