package com.example.assignment_xpotato

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Room : AppCompatActivity() {
    var modalList = ArrayList<Modal>()

    var names = arrayOf(
            "A501", "A502", "A503", "A504",
            "A401", "A402", "A403", "A404",
            "A301", "A302", "A303", "A304",
            "A201", "A202", "A203", "A204",
            "A101", "A102", "A103", "A104")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val backBtn = findViewById<Button>(R.id.r_backBtn)


        backBtn.setOnClickListener(){
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
        for (i in names.indices) {
            modalList.add(Modal(names[i]))
        }
        var customAdapter = customAdapter(modalList, this);
        var gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = customAdapter;
        gridView.bringToFront()
        gridView.invalidate()
        gridView.setOnItemClickListener { parent, view, i, id ->
            var dialog = RoomFragment()
            val bundle = Bundle()
            bundle.putSerializable("RoomNumber", modalList[i].name)

            dialog.arguments = bundle
            dialog.show(supportFragmentManager, "customDialog")
            /*
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("roomNumber",modalList[i].name)
            startActivity(intent)
             */
        }


    }


    class customAdapter(
            var itemModel: ArrayList<Modal>,
            var context: Context
    ) : BaseAdapter() {

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view;
            if (view == null) {
                view = layoutInflater.inflate(R.layout.room_list, viewGroup, false);
            }
            var tvName = view?.findViewById<TextView>(R.id.rl_roomNumberTV)
            tvName?.text = itemModel[position].name;




            return view!!;
        }

        override fun getItem(position: Int): Any {
            return itemModel[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return itemModel.size
        }

    }
}
