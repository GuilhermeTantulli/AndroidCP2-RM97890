package br.com.guilhermetantulli.androidcp2_rm97890

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // Habilita o botão de voltar na barra de ação
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    // Tratar o evento de clique no botão de voltar da barra de ação
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed() // Simular o comportamento do botão de voltar físico
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}