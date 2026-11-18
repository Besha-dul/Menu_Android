package com.utxicotepec.menusandroid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import android.widget.Button
import android.widget.PopupMenu

class Hoja5EmergenteActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja5_emergente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)


        val btnMostrarMenu = findViewById<Button>(R.id.btnMostrarMenu)

        btnMostrarMenu.setOnClickListener {

            val popup = PopupMenu(this, btnMostrarMenu)

            popup.menuInflater.inflate(R.menu.menu_hoja5, popup.menu)

            popup.setOnMenuItemClickListener { item ->

                when (item.itemId) {

                    R.id.opcion_guardar -> {
                        txtResultado.text = "Seleccionaste: Guardar"
                        true
                    }

                    R.id.opcion_compartir -> {
                        txtResultado.text = "Seleccionaste: Compartir"
                        true
                    }

                    R.id.opcion_salir -> {
                        txtResultado.text = "Seleccionaste: Salir"
                        true
                    }

                    else -> false
                }
            }

            popup.show()
        }

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
}
