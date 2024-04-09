package br.com.guilhermetantulli.androidcp2_rm97890

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val taxa = intent.getDoubleExtra("taxa", 0.0)
        val resultado1 = intent.getDoubleExtra("resultado1", 0.0)
        val resultado2 = intent.getDoubleExtra("resultado2", 0.0)
        val total = taxa + resultado1 + resultado2

        val resultadoView = findViewById<TextView>(R.id.resultadoView)
        resultadoView.text = String.format("Taxa: \t\t R$ %.2f\n" +
                "Chamada Local: \t\t R$ %.2f\n" +
                "Chamada Celular: \t\t R$ %.2f\n\n" +
                "Total: R$ %.2f", taxa, resultado1, resultado2, total)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed() // Simular o comportamento do botão de voltar físico
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}