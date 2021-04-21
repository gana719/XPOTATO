package com.example.assignment_xpotato

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_xpotato.MainActivity.Companion.bookingID
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class BookingCheckIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var selectDay : Int = 0
        var selectMonth : Int = 0
        var selectYear : Int = 0
        var selectOutDay : Int = 0
        var selectOutMonth : Int = 0
        var selectOutYear : Int = 0
        var totalDayOut : Double = 0.00
        var totalDayIn  : Double = 0.00
        val database = FirebaseDatabase.getInstance()






        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_checkin)
        val backBtn = findViewById<Button>(R.id.bc_backBtn)
        val bookingInBtn = findViewById<Button>(R.id.bc_bookingBtn)
        val booking_checkinBtn = findViewById<Button>(R.id.bc_booking_CheckInBtn)

        var roomNumberTv = findViewById<TextView>(R.id.bc_room_numberTV)

        var intent = intent
        val roomNumber = intent.getStringExtra("roomNumber")
        roomNumberTv.setText(roomNumber)
        val roomNumberDB = database.getReference(roomNumber.toString())



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
                selectDay = mDay
                selectMonth = mMonth+1
                selectYear = mYear
                totalDayIn = selectDay+selectMonth*30+selectYear*365.25
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
                 selectOutDay = mDay
                selectOutMonth = mMonth+1
                selectOutYear = mYear

                totalDayOut = selectOutDay+selectOutMonth*30+selectOutYear*365.25
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

            roomNumberDB.child(bookingID.toString()).child("Name").setValue(name)
            roomNumberDB.child(bookingID.toString()).child("Phone Number").setValue(phone)
            roomNumberDB.child(bookingID.toString()).child("IC").setValue(IC)
            roomNumberDB.child(bookingID.toString()).child("Number of Guest").setValue(numberOfGuest)
            roomNumberDB.child(bookingID.toString()).child("dayIn").setValue(selectDay)
            roomNumberDB.child(bookingID.toString()).child("monthIn").setValue(selectMonth)
            roomNumberDB.child(bookingID.toString()).child("yearIn").setValue(selectYear)
            roomNumberDB.child(bookingID.toString()).child("dayOut").setValue(selectOutDay)
            roomNumberDB.child(bookingID.toString()).child("monthOut").setValue(selectOutMonth)
            roomNumberDB.child(bookingID.toString()).child("yearOut").setValue(selectOutYear)
            roomNumberDB.child(bookingID.toString()).child("totalDayIn").setValue(totalDayIn)
            roomNumberDB.child(bookingID.toString()).child("totalDayOut").setValue(totalDayOut)
            roomNumberDB.child(bookingID.toString()).child("Email").setValue(email)
            roomNumberDB.child(bookingID.toString()).child("Status").setValue(status)
            val intent = Intent(this, Room::class.java)
            startActivity(intent)



        }
        backBtn.setOnClickListener(){
            val intent = Intent(this, Room::class.java)
            startActivity(intent)
        }
        booking_checkinBtn.setOnClickListener(){
            //status 0 = booked, 1 = checked in
            val status : Int = 1
            val name: String = findViewById<TextView>(R.id.bc_guest_name_EditText).text.toString()
            val phone: String = findViewById<TextView>(R.id.bc_guest_phoneNumber_EditText).text.toString()
            val IC : String = findViewById<TextView>(R.id.bc_guest_ICNumber_EditText).text.toString()
            val numberOfGuest : String = findViewById<TextView>(R.id.bc_guest_number_EditText).text.toString()
            val email = findViewById<TextView>(R.id.bc_guest_Email_EditText).text.toString()
            val checkInDate : String = checkInCalendarTV.text.toString()
            val checkOutDate : String = checkOutCalendarTV.text.toString()

            bookingID++

            roomNumberDB.child(bookingID.toString()).child("Name").setValue(name)
            roomNumberDB.child(bookingID.toString()).child("Phone Number").setValue(phone)
            roomNumberDB.child(bookingID.toString()).child("IC").setValue(IC)
            roomNumberDB.child(bookingID.toString()).child("Number of Guest").setValue(numberOfGuest)
            roomNumberDB.child(bookingID.toString()).child("dayIn").setValue(selectDay)
            roomNumberDB.child(bookingID.toString()).child("monthIn").setValue(selectMonth)
            roomNumberDB.child(bookingID.toString()).child("yearIn").setValue(selectYear)
            roomNumberDB.child(bookingID.toString()).child("dayOut").setValue(selectOutDay)
            roomNumberDB.child(bookingID.toString()).child("monthOut").setValue(selectOutMonth)
            roomNumberDB.child(bookingID.toString()).child("yearOut").setValue(selectOutYear)
            roomNumberDB.child(bookingID.toString()).child("totalDayIn").setValue(totalDayIn)
            roomNumberDB.child(bookingID.toString()).child("totalDayOut").setValue(totalDayOut)
            roomNumberDB.child(bookingID.toString()).child("Email").setValue(email)
            roomNumberDB.child(bookingID.toString()).child("Status").setValue(status)

            val intent = Intent(this, Room::class.java)
            startActivity(intent)



        }


    }


}