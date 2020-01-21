package com.example.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.ButToast) {
            // vou criar um toast editável
            // para isso crio uma variável
        val toast = Toast.makeText(this, "SUCESSO!", Toast.LENGTH_LONG)

            //editei para mudar a cor do texto
            //toast.view.findViewById<TextView>(android.R.id.message).setTextColor(android.graphics.Color.BLUE)

            //editei o layout tem de instanciar usando o layoutinflater
            val toastLayout = layoutInflater.inflate(R.layout.toast_custom, null)
            toast.view = toastLayout
            toast.view.findViewById<TextView>(R.id.TextToast).setText("SUCESSO!")
            toast.show()
        }
    }

    private fun setListeners(){
        ButToast.setOnClickListener(this)

    }

}
