package br.com.guilhermetantulli.androidcp2_rm97890

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //Capturando os elementos por ID
        val valorEdit1 = findViewById<EditText>(R.id.textoValor1)
        val valorEdit2 = findViewById<EditText>(R.id.textoValor2)
        val operacaoRadioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonCalc = findViewById<Button>(R.id.button)

        buttonCalc.setOnClickListener {
            val valor1 = valorEdit1.text.toString().toDoubleOrNull()
            val valor2 = valorEdit2.text.toString().toDoubleOrNull()

            // Adiciona um Toast para caso nada seja digitado nos campos de valor
            if (valor1 == null || valor2 == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // When para cada operação de radio listada no arquivo .xml
            val resultado = when (operacaoRadioGroup.checkedRadioButtonId) {
                R.id.radioSoma -> valor1 + valor2
                R.id.radioSubtracao -> valor1 - valor2
                R.id.radioMultiplicacao -> valor1 * valor2
                R.id.radioDivisao -> if (valor2 != 0.0) {
                    valor1/valor2
                } else "Não é possível fazer divisão por zero."
                else -> null
            }

            // Condicional para caso haja divisão por 0 + exibição do resultado via Toast.
            if (resultado == null) {
                Toast.makeText(this, "Operação inválida.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_SHORT).show()
            }
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