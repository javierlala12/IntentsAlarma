package com.javiervillaverde.intentsalarma

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ConfigurarAlarma  : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_alarma)

        val nombreAlarmaEditText = findViewById<EditText>(R.id.nombreAlarmaEditText)
        val horaEditText = findViewById<EditText>(R.id.horaEditText)
        val minutosEditText = findViewById<EditText>(R.id.minutosEditText)
        val guardarButton = findViewById<Button>(R.id.guardarButton)

        guardarButton.setOnClickListener {
            val nombreAlarma = nombreAlarmaEditText.text.toString()
            val hora = horaEditText.text.toString()
            val minutos = minutosEditText.text.toString()

            if (nombreAlarma.isNotEmpty() && hora.isNotEmpty() && minutos.isNotEmpty()) {
                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, nombreAlarma)
                    .putExtra(AlarmClock.EXTRA_HOUR, hora.toInt())
                    .putExtra(AlarmClock.EXTRA_MINUTES, minutos.toInt())

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

