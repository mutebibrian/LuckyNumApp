package com.mastercoding.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)


        val text1 : TextView = findViewById(R.id.text1)
        val luckyText: TextView  = findViewById(R.id.luckyNumTxt)
        val shareBtn: Button = findViewById(R.id.shareBtn)

        var user_name = receiveUserName()

        var random_num = generateRandomNum()

        luckyText.setText(""+random_num)

        shareBtn.setOnClickListener(){
            shareData(user_name, random_num)
        }
    }

    fun receiveUserName():String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }


    // Random Numbers Generator
    fun generateRandomNum(): Int{
        val random = Random.nextInt(1000)
        return random
    }

    // sharing the username & number
    fun shareData(username: String, num : Int){

        // Implicit Intent
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today" )
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num" )
        startActivity(i)
    }


}