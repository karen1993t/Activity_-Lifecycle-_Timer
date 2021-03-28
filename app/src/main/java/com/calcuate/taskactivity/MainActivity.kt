package com.calcuate.taskactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btnStartTimer: Button
    lateinit var btnNexPage: Button
    lateinit var textTimer: TextView
    var countDownTimer: CountDownTimer? = null
    var millisecond: Long = 0
    var millis: Long = 15000
    var checked: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNexPage = findViewById(R.id.btn_nextPage)
        btnStartTimer = findViewById(R.id.btn_startTimer)
        textTimer = findViewById(R.id.tv_timerShow)

        btnNexPage.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("milli", millisecond)
            startActivity(intent)
        }
        btnStartTimer.setOnClickListener {
            timerStart(millis)
            checked = true
            countDownTimer?.start()
        }

    }

    override fun onStart() {
        super.onStart()
        if (checked) {
            timerStart2(millisecond)
        }
    }

    override fun onStop() {
        super.onStop()
        countDownTimer?.cancel()
    }

    private fun timerStart(millis: Long) {
        countDownTimer = object : CountDownTimer(millis, 1000) {
            override fun onTick(mil: Long) {
                textTimer.text = (mil / 1000).toString()
                millisecond = mil

            }

            override fun onFinish() {
                textTimer.text = "Finished"
            }
        }
    }

    private fun timerStart2(milliseconds: Long) {
        countDownTimer = object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(mil: Long) {
                textTimer.text = (mil / 1000).toString()
                millisecond = mil
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                textTimer.text = "Finished"
            }
        }
        countDownTimer?.start()
    }
}