package com.javiervillaverde.intentsalarma

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetAlarm: Button = findViewById(R.id.btnSetAlarm)
        val btnWebSearch: Button = findViewById(R.id.btnWebSearch)
        val btnViewContacts: Button = findViewById(R.id.btnViewContacts)


        btnSetAlarm.setOnClickListener {
            val intent = Intent(this, ConfigurarAlarma::class.java)
            startActivity(intent)

            //alarma()
        }

        btnWebSearch.setOnClickListener {
            buscarWeb()
        }

        btnViewContacts.setOnClickListener {
            verContactos()
        }
    }

    private fun verContactos() {
        val intent = Intent(Intent.ACTION_VIEW).setData(ContactsContract.Contacts.CONTENT_URI)
        startActivity(intent)
    }

    private fun buscarWeb() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).putExtra(
            SearchManager.QUERY,
            "Google"
        )
        startActivity(intent)
    }

   // private fun alarma() {
       // val intent = Intent(AlarmClock.ACTION_SET_ALARM).putExtra(
         //   AlarmClock.EXTRA_MESSAGE,
          //  "Nombre de la alarma"
      //  ).putExtra(AlarmClock.EXTRA_HOUR, 12).putExtra(AlarmClock.EXTRA_MINUTES, 0)
       // startActivity(intent)
   // }
}