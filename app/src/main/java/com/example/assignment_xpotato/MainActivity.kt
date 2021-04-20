package com.example.assignment_xpotato

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), BookingAdapter.OnItemClickListener {


    private val arrBooking = ArrayList<BookingView>()
    private val adapter = BookingAdapter(arrBooking, this)


    companion object {

        var bookingID : Int = 100

        val database = FirebaseDatabase.getInstance()

        val A101 = database.getReference("A101")
        val A102 = database.getReference("A102")
        val A103 = database.getReference("A103")
        val A104 = database.getReference("A104")

        val A201 = database.getReference("A201")
        val A202 = database.getReference("A202")
        val A203 = database.getReference("A203")
        val A204 = database.getReference("A204")

        val A301 = database.getReference("A301")
        val A302 = database.getReference("A302")
        val A303 = database.getReference("A303")
        val A304 = database.getReference("A304")

        val A401 = database.getReference("A401")
        val A402 = database.getReference("A402")
        val A403 = database.getReference("A403")
        val A404 = database.getReference("A404")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_test)

        //val btnInsert: Button = findViewById(R.id.insertBtn)






        /*btnInsert.setOnClickListener() {
            val name: String = findViewById<TextView>(R.id.inputName).text.toString()
            val phone: String = findViewById<TextView>(R.id.inputPhone).text.toString()

            bookingID++

            A101.child(bookingID.toString()).child("Name").setValue(name)
            A101.child(bookingID.toString()).child("Phone Number").setValue(phone)
        }*/

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
                        arrBooking += BookingView(
                            s.child("Name").getValue().toString(),
                            s.child("Phone Number").getValue().toString()

                        )
                    }
                }

               /* val recyclerView: RecyclerView = findViewById(R.id.output)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(application)
                recyclerView.setHasFixedSize(true)*/
            }
        }

//        val btnGet:Button = findViewById(R.id.getBtn)
//        btnGet.setOnClickListener(){
//
//            //val q : Query = A101.orderByChild("Phone Number").equalTo("100")
//            val q : Query = A101.orderByChild("Phone Number").startAfter("123")
//
//            q.addValueEventListener(getData)
//            q.addListenerForSingleValueEvent(getData)
//        }


    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = arrBooking[position]
        clickedItem.checkInDate = "Clicked"
        adapter.notifyItemChanged(position)
    }
}