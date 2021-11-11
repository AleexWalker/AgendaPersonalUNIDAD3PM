package com.example.agendapersonalunidad3pm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE)

        button.setOnClickListener {
            val editorTexto = preferencias.edit()
            editorTexto.putString(editTextTextPersonName.text.toString(), editTextTextPersonName2.text.toString())
            editorTexto.apply()

            Toast.makeText(this, "¡Datos del usuario guardados!", Toast.LENGTH_LONG).show()
            editTextTextPersonName.setText("")
            editTextTextPersonName2.setText("")
        }

        button2.setOnClickListener {
            val datos = preferencias.getString(editTextTextPersonName.text.toString(), "")
            if (datos != null) {
                if (datos.isEmpty())
                    Toast.makeText(this, "¡No existe el nombre especificado en la Agenda!", Toast.LENGTH_LONG).show()
                else
                    editTextTextPersonName2.setText(datos)
            }
        }
    }
}