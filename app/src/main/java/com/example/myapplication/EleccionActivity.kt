package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EleccionActivity : AppCompatActivity() {

    private lateinit var lblResultado : TextView
    private lateinit var btAzul : RadioButton
    private lateinit var btRojo : RadioButton
    private lateinit var radioGroup : RadioGroup
    private lateinit var btnLimpiar : Button
    var option : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        // obtener una referencia a la etiqueta de la actividad
        val lblBienvenido = findViewById<TextView>(R.id.txtSaludo)



        // recogemos el nombre del intent
        val nombre = intent.getStringExtra("NOMBRE")
        val texto = "Bienvenido ${nombre}, ha llegado el momento de tomar una dificil decisión."
        // creamos la cadena del saludo
        lblBienvenido.apply {
            text = texto
        }
        radioGroup = findViewById<RadioGroup>(R.id.txtDecision)
        btAzul = findViewById<RadioButton>(R.id.btnAzul)
        btRojo = findViewById<RadioButton>(R.id.btnRojo)
        lblResultado = findViewById<TextView>(R.id.txtResultado)
        btnLimpiar = findViewById<Button>(R.id.txtLimpiar)

        btnLimpiar.setOnClickListener {
            radioGroup.clearCheck()
        }


    }

    fun mostrarFinal(view : View) {
        if (radioGroup.checkedRadioButtonId == -1) {
            lblResultado.apply {
                text = "Debes seleccionar una acción..."
            }
        } else {
            val intent = Intent(this, FinalActivity::class.java)

            intent.putExtra("key", option)

            startActivity(intent)
        }
    }

    fun radioButtonOnClick(view : View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            val lblPastilla = findViewById<TextView>(R.id.txtResultado)
            when (view.getId()) {
                R.id.btnRojo ->
                    if (checked) {
                        lblPastilla.apply {
                            text = "Estas eligiendo seguir con tu miserable vida"
                            option = true
                        }
                    }
                R.id.btnAzul ->
                    if (checked) {
                        lblPastilla.apply {
                            text = "Estás apunto de adentrarte en la Matrix Phone"
                            option = false
                        }
                    }
            }
        }
    }




}