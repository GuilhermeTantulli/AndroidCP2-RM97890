package br.com.guilhermetantulli.androidcp2_rm97890

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        // Capturando os elementos por ID
        val valorFixo = findViewById<EditText>(R.id.textoFixo)
        val valorEdit1 = findViewById<EditText>(R.id.textoValor1)
        val valorEdit2 = findViewById<EditText>(R.id.textoValor2)
        val buttonCalc = findViewById<Button>(R.id.button)

        // Colocando evento no botão para fazer o cálculo e já exibir na tela seguinte
        buttonCalc.setOnClickListener {

            // Validação de tipo de dado no campo (para que não seja string, nem nulo)
            val taxa = valorFixo.text.toString().toDoubleOrNull()
            val valor1 = valorEdit1.text.toString().toDoubleOrNull()
            val valor2 = valorEdit2.text.toString().toDoubleOrNull()

            // Tratativa de erro -> Adiciona um Toast para caso "" seja digitado nos campos de valor
            if (valor1 == null || valor2 == null || taxa == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Matemática dos valores de acordo com projeto
            val resultado1 = valor1 * 0.04
            val resultado2 = valor2 * 0.20

            // Variável que salva os valores para exibição na tela seguinte
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("taxa", taxa)
                putExtra("resultado1", resultado1)
                putExtra("resultado2", resultado2)
            }
            startActivity(intent)
        }

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