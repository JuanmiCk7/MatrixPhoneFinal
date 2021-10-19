package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.content.Intent





class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val lblFinal = findViewById<TextView>(R.id.txtFinal)
        val extras = intent.extras
        if (extras != null) {
            val value = extras.getBoolean("key")
            if (value) {
                lblFinal.apply {
                    text = "Has elegido seguir con tu miserable vida"
                }
            } else {
                lblFinal.apply {
                    text = "Has elegido adentrarte en el mundo de la programación móvil"
                }
            }
        }




    }

    fun cerrarApp(view : View) {
        val homeIntent = Intent(Intent.ACTION_MAIN)
        homeIntent.addCategory(Intent.CATEGORY_HOME)
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(homeIntent)
    }
}