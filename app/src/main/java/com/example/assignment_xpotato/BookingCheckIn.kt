package com.example.assignment_xpotato

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BookingCheckIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_checkin)



        val booking_checkinBtn = findViewById<Button>(R.id.bc_booking_CheckInBtn)
        val fiosdgjfd : String = "100"
        var fidj : Int = fiosdgjfd.toInt()+1
        var roomNumberTv = findViewById<TextView>(R.id.room_numberTV)

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


    }


}