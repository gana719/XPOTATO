package com.example.assignment_xpotato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class food_beverage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_beverage)

        var intent = intent
        val roomNumber = intent.getStringExtra("roomNumber")
        findViewById<TextView>(R.id.fb_RoomTV).setText(roomNumber)

        val cancelBtn = findViewById<Button>(R.id.fb_cancelBtn)
        cancelBtn.setOnClickListener(){
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        val backBtn = findViewById<Button>(R.id.fb_backBtn)
        backBtn.setOnClickListener(){
            val intent = Intent (this, RoomService::class.java)
            startActivity(intent)
        }

      /*  val confirmBtn = findViewById<Button>(R.id.ri_confirmBtn)
        confirmBtn.setOnClickListener(){
            val intent = Intent (this, RoomService::class.java)
            Toast.makeText(this, "$roomNumber is going to be refilled.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }*/

        var chickenChopQty : Int = 0
        var fishChipsQty : Int = 0
        var macCheeseQty : Int = 0
        var spaghettiQty : Int = 0
        var champagneQty : Int = 0
        var redWineQty : Int = 0
        val chickenChopPrice = 13.90
        val spaghettiPrice = 8.90
        val fishChipsPrice = 13.90
        val macCheesePrice = 9.90
        val champagnePrice = 129.90
        val redWinePrice = 64.90
        var total : Double
        val totalTV = findViewById<TextView>(R.id.fb_totalTV)

        fun calculateTotal() {
            total = (chickenChopQty*chickenChopPrice) + (fishChipsPrice*fishChipsQty) + (macCheesePrice*macCheeseQty)+(spaghettiPrice*spaghettiQty)+(champagnePrice*champagneQty)+(redWinePrice*redWineQty)
            val rounded = String.format("%.2f", total)
            totalTV.setText("RM"+rounded.toString())
        }




        val chickenChopQtyTV = findViewById<TextView>(R.id.fb_chickenChopQtyTV)
        val chickenChopMinusBtn = findViewById<Button>(R.id.fb_chickenChopMinusBtn)
        val chickenChopPlusBtn = findViewById<Button>(R.id.fb_chickenChopPlusBtn)
        chickenChopMinusBtn.setOnClickListener(){
            if(chickenChopQty>0){
                chickenChopQty-=1
                chickenChopQtyTV.setText(chickenChopQty.toString())
                calculateTotal()
            }
        }
        chickenChopPlusBtn.setOnClickListener(){
            if(chickenChopQty<99){
                chickenChopQty+=1
                chickenChopQtyTV.setText(chickenChopQty.toString())
                calculateTotal()
            }
        }

        val spaghettiQtyTV = findViewById<TextView>(R.id.fb_spaghettiQtyTV)
        val spaghettiMinusBtn = findViewById<Button>(R.id.fb_spaghettiMinusBtn)
        val spaghettiPlusBtn = findViewById<Button>(R.id.fb_spaghettiPlusBtn)
        spaghettiMinusBtn.setOnClickListener(){
            if(spaghettiQty>0){
                spaghettiQty-=1
                spaghettiQtyTV.setText(spaghettiQty.toString())
                calculateTotal()
            }
        }
        spaghettiPlusBtn.setOnClickListener(){
            if(spaghettiQty<99){
                spaghettiQty+=1
                spaghettiQtyTV.setText(spaghettiQty.toString())
                calculateTotal()
            }
        }

        val fishChipsQtyTV = findViewById<TextView>(R.id.fb_fishChipsQtyTV)
        val fishChipsMinusBtn = findViewById<Button>(R.id.fb_fishChipsMinusBtn)
        val fishChipsPlusBtn = findViewById<Button>(R.id.fb_fishChipsPlusBtn)
        fishChipsMinusBtn.setOnClickListener(){
            if(fishChipsQty>0){
                fishChipsQty-=1
                fishChipsQtyTV.setText(fishChipsQty.toString())
                calculateTotal()
            }
        }
        fishChipsPlusBtn.setOnClickListener(){
            if(fishChipsQty<99){
                fishChipsQty+=1
                fishChipsQtyTV.setText(fishChipsQty.toString())
                calculateTotal()
            }
        }

        val macCheeseQtyTV = findViewById<TextView>(R.id.fb_macCheeseQtyTV)
        val macCheeseMinusBtn = findViewById<Button>(R.id.fb_macCheeseMinusBtn)
        val macCheesePlusBtn = findViewById<Button>(R.id.fb_macCheesePlusBtn)
        macCheeseMinusBtn.setOnClickListener(){
            if(macCheeseQty>0){
                macCheeseQty-=1
                macCheeseQtyTV.setText(macCheeseQty.toString())
                calculateTotal()
            }
        }
        macCheesePlusBtn.setOnClickListener(){
            if(macCheeseQty<99){
                macCheeseQty+=1
                macCheeseQtyTV.setText(macCheeseQty.toString())
                calculateTotal()
            }
        }

        val champagneQtyTV = findViewById<TextView>(R.id.fb_champagneQtyTV)
        val champagneMinusBtn = findViewById<Button>(R.id.fb_champagneMinusBtn)
        val champagnePlusBtn = findViewById<Button>(R.id.fb_champagnePlusBtn)
        champagneMinusBtn.setOnClickListener(){
            if(champagneQty>0){
                champagneQty-=1
                champagneQtyTV.setText(champagneQty.toString())
                calculateTotal()
            }
        }
        champagnePlusBtn.setOnClickListener(){
            if(champagneQty<99){
                champagneQty+=1
                champagneQtyTV.setText(champagneQty.toString())
                calculateTotal()
            }
        }

        val redWineQtyTV = findViewById<TextView>(R.id.fb_redWineQtyTV)
        val redWineMinusBtn = findViewById<Button>(R.id.fb_redWineMinusBtn)
        val redWinePlusBtn = findViewById<Button>(R.id.fb_redWinePlusBtn)
        redWineMinusBtn.setOnClickListener(){
            if(redWineQty>0){
                redWineQty-=1
                redWineQtyTV.setText(redWineQty.toString())
                calculateTotal()
            }
        }
        redWinePlusBtn.setOnClickListener(){
            if(redWineQty<99){
                redWineQty+=1
                redWineQtyTV.setText(redWineQty.toString())
                calculateTotal()
            }
        }
    }
}