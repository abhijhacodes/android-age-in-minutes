package com.example.ageinminutes

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener{view ->
            clickDatePicker(view)
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    _, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this, "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate.text = selectedDate

                val today = "09/06/2021"

                val dates = SimpleDateFormat("dd/MM/yyyy")

                val date1: Date = dates.parse(selectedDate)
                val date2: Date = dates.parse(today)

                val diff: Long = abs(date1.time - date2.time)
                val diffDates = diff / (24*60*60*1000)
                val minutes = diffDates*1440
                val ans = minutes.toString()

                tvSelectedDateInMinute.text = ans
            }
            ,year
            ,month
            ,day).show()
    }
}