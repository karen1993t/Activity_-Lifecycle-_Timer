package com.calcuate.taskactivity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class NewActivity : AppCompatActivity() {


    lateinit var textShow: TextView
    lateinit var timer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        Log.d("testApp", "OnCreate called")
        textShow = findViewById(R.id.tv_timerShow1)


        val intent:Intent = getIntent()
        val extrasValue: Bundle? = intent.extras
        var milliSeconds:Long = 0L

       if (extrasValue != null){
           milliSeconds = extrasValue.getLong("milli")
       }




        timer = object : CountDownTimer(milliSeconds, 1000) {
            override fun onTick(timMili: Long) {
                textShow.text = (timMili / 1000).toString()
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                textShow.text = "Finished"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("testApp", "OnStart called")
        timer.start()

    }

     override fun onStop() {
        super.onStop()
        Log.d("testApp", "OnStop called")
        timer.cancel()
    }

}