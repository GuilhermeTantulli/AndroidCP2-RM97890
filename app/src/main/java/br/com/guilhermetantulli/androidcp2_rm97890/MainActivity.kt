package br.com.guilhermetantulli.androidcp2_rm97890

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar os elementos visuais pelo ID
        val buttonCalc = findViewById<Button>(R.id.buttonCalc)
        val buttonPhone = findViewById<Button>(R.id.buttonPhone)
        val buttonStudent = findViewById<Button>(R.id.buttonStudent)

        buttonCalc.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        buttonPhone.setOnClickListener {
            val intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)
        }
    }


}