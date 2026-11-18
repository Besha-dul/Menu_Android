package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)
        val txtIndicacion = findViewById<TextView>(R.id.txtIndicacion)

        registerForContextMenu(txtIndicacion)
        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: android.view.View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_hoja3, menu)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.opcion_copiar -> {
                val clipboard = getSystemService(CLIPBOARD_SERVICE)
                        as android.content.ClipboardManager

                val clip = android.content.ClipData.newPlainText(
                    "Texto",
                    txtResultado.text
                )

                clipboard.setPrimaryClip(clip)
                txtResultado.text = "Texto copiado"
                return true
            }

            R.id.opcion_editar -> {
                txtResultado.text = "Texto editado"
                return true
            }

            R.id.opcion_eliminar -> {
                txtResultado.text = "Elemento eliminado"
                return true
            }
        }

        return super.onContextItemSelected(item)
    }

}
