package br.com.guilhermetantulli.androidcp2_rm97890

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Capturando os elementos por ID
        val buttonCalc = findViewById<Button>(R.id.buttonCalc)
        val buttonPhone = findViewById<Button>(R.id.buttonPhone)
        val buttonStudent = findViewById<Button>(R.id.buttonStudent)

        // Definir ações ao tap do botão -> Ir para a tela da calculadora
        buttonCalc.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        // Definir ações ao tap do botão -> Ir para a tela da conta telefônica
        buttonPhone.setOnClickListener {
            val intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)
        }

        // Chamada da função de exibição de assinatura
        buttonStudent.setOnClickListener {
            showSignature()
        }
    }


    // Função para exibir a assinatura do aplicativo
    private fun showSignature() {
        val mySignature = """
            Nome: Guilherme Tantulli
            RM: 97890
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Desenvolvido Por")
            .setMessage(mySignature)
            .setPositiveButton("Ok") { dialog, which ->

            }
            .show()
    }

}