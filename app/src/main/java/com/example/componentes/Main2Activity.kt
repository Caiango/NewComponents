package com.example.componentes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class Main2Activity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    //formatei a data para como quero
    private val mSimpleDateFormat = SimpleDateFormat("dd/MM/yy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setListener()
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.ButDate) {
            openDatapickerDialog()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //formatei a data e mandei para o Butdate
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val value = mSimpleDateFormat.format(calendar.time)
        ButDate.text = value
        textView1.text = year.toString()
    }

    private fun setListener() {
        ButDate.setOnClickListener(this)

    }

    private fun openDatapickerDialog() {
        //calendario
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        //instaciei o datepcikdialog para poder utilizar
        DatePickerDialog(this, this, year, month, day).show()
    }
}
