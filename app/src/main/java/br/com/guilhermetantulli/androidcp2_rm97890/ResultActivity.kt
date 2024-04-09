package br.com.guilhermetantulli.androidcp2_rm97890

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Capturando as variáveis salvas em putExtra da tela anterior para serem exibidas nessa tela
        // instanciando-as com valor 0.0 para que não haja erro de exibição
        val taxa = intent.getDoubleExtra("taxa", 0.0)
        val resultado1 = intent.getDoubleExtra("resultado1", 0.0)
        val resultado2 = intent.getDoubleExtra("resultado2", 0.0)

        // Variável para salvar o valor total que será a última linha exibida, com matemática simples.
        val total = taxa + resultado1 + resultado2

        // Capturando a textView do xml da sub-tela e colocando os valores dentro dele
        // formatação de duas casas decimais e formato de valor em BRL.
        val resultadoView = findViewById<TextView>(R.id.resultadoView)
        resultadoView.text = String.format("Taxa: \t\t R$ %.2f\n" +
                "Chamada Local: \t\t R$ %.2f\n" +
                "Chamada Celular: \t\t R$ %.2f\n\n" +
                "Total: R$ %.2f", taxa, resultado1, resultado2, total)

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