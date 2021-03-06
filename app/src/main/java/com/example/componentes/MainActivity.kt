package com.example.componentes

import android.app.ProgressDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

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
        } else if (id == R.id.ButSnack) {
            //lembrar de importar no gradle app (implementation"com.android.support:design:26.1.1") e componentes a biblioteca (maven)
            val snack = Snackbar.make(constraint, "SnackBar funcional", Snackbar.LENGTH_LONG)
            //snack.view.setBackgroundColor(Color.BLUE)
            // se eu quiser pegar uma cor do meu arquivo
            snack.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBack))


            //vou setar um evento de click na snack
            snack.setAction("Clica de novo", {
                val snack2 = Snackbar.make(constraint, "SnackBar Desfazer", Snackbar.LENGTH_LONG)
                snack2.view.setBackgroundColor(Color.RED)
                snack2.show()
            })

            snack.show()
        } else if (id == R.id.ButProgress) {
            //balao de carregamento
            val progress: ProgressDialog = ProgressDialog(this)
            progress.setTitle("ProgressDialog")
            progress.setMessage("Carregando seu processo")
            progress.show()

            /*
            para fechar via codigo o progress Dialog (o hide e o miss tem de vir juntos)
            progress.hide()
            progress.dismiss()
            */

        } else if (id == R.id.ButActivity) {
            //  chamando outra activity
            val intent: Intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)

        }

    }

    private fun setListeners() {
        ButToast.setOnClickListener(this)
        ButSnack.setOnClickListener(this)
        ButProgress.setOnClickListener(this)
        ButActivity.setOnClickListener(this)

    }

}
