
package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        val txtIndicacion = findViewById<TextView>(R.id.txtIndicacion)

        txtIndicacion.setOnLongClickListener {
            startSupportActionMode(modoAccion)
            true
        }

        // ZONA A: aquí van las instrucciones del tutorial
    }

    // ZONA B: funciones del modo de acción contextual

    private val modoAccion = object : ActionMode.Callback {

        override fun onCreateActionMode(
            mode: ActionMode,
            menu: Menu
        ): Boolean {
            mode.menuInflater.inflate(R.menu.menu_hoja4, menu)
            return true
        }

        override fun onPrepareActionMode(
            mode: ActionMode,
            menu: Menu
        ): Boolean {
            return false
        }

        override fun onActionItemClicked(
            mode: ActionMode,
            item: MenuItem
        ): Boolean {

            when (item.itemId) {

                R.id.accion_editar -> {
                    txtResultado.text = "Texto editado"
                    mode.finish()
                    return true
                }

                R.id.accion_compartir -> {
                    txtResultado.text = "Texto compartido"
                    mode.finish()
                    return true
                }

                R.id.accion_eliminar -> {
                    txtResultado.text = "Elemento eliminado"
                    mode.finish()
                    return true
                }
            }

            return false
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            // La barra contextual desaparece automáticamente.
        }
    }
}
