package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

private lateinit var lblAviso : TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.getBooleanExtra("EXIT", false)) {
            finish()
        }

    }

    fun mostrarEleccion(view : View) {
        val txtNombre = this.findViewById<EditText>(R.id.txtNombre)



        if (txtNombre.toString().trim().isNotEmpty()) {
            //crear el intent
            val intent = Intent(this@MainActivity, EleccionActivity::class.java)
            //tomar el valor del cuadro de texto.

            //añadimos la información necesaria al intent
            intent.putExtra("NOMBRE", txtNombre.text.toString())

            //iniciar la nueva actividad
            startActivity(intent)
        } else {
            lblAviso = findViewById(R.id.txtAviso)
            lblAviso.apply {
                text = "Debes introducir un nombre..."
            }
        }
    }
}