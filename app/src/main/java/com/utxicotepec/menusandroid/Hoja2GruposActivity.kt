package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja2GruposActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja2_grupos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)
        txtResultado.text = "Seleccionaste: Rojo"

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_hoja2, menu)

        menu.setGroupCheckable(
            R.id.grupo_opciones,
            true,
            true
        )

        menu.findItem(R.id.opcion_rojo).isChecked = true

        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.opcion_rojo -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Rojo"
                return true
            }

            R.id.opcion_azul -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Azul"
                return true
            }

            R.id.opcion_verde -> {
                item.isChecked = true
                txtResultado.text = "Seleccionaste: Verde"
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


}
