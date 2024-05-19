package com.example.pc_wilfredoramos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etxtExamenParcial = findViewById<EditText>(R.id.etxtExamenParcial)
        val etxtExamenFinal = findViewById<EditText>(R.id.etxtExamenFinal)
        val etxtPEP = findViewById<EditText>(R.id.etxtPEP)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            this.evaluarNota(etxtExamenParcial.text.toString(),etxtExamenFinal.text.toString(),etxtPEP.text.toString() )

        }
    }

    private fun evaluarNota(examenParcial: String,examenFinal: String, pep: String){
        val pesoParcial = 0.20
        val pesoFinal = 0.2
        val pesoPep = 0.60

        val notaFinal = (examenParcial.toDouble() * pesoParcial) + (examenFinal.toDouble() * pesoFinal ) + (pep.toDouble() * pesoPep)

        var resultado = ""

        if (notaFinal >= 10.5){
            resultado = "APROBADO"

        }else{
            resultado = "DESAPROBADO"
        }

        val intent = Intent(this,ResultadoActivity::class.java)
        intent.putExtra("resultado",resultado)
        intent.putExtra("notaFinal",notaFinal.toString())
        startActivity(intent)

    }


}

