package com.example.pc_wilfredoramos

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etxtNotaFinal = findViewById<TextView>(R.id.etxtNotaFinal)
        val etxtResultado = findViewById<TextView>(R.id.etxtResultado)

        val notaFinal = intent.getStringExtra("notaFinal")
        val resultado = intent.getStringExtra("resultado")

        if (resultado =="APROBADO"){
            etxtResultado.setTextColor(Color.BLUE)

        }else{
            etxtResultado.setTextColor(Color.RED)
        }

        etxtResultado.text = resultado.toString();
        etxtNotaFinal.text = notaFinal.toString();

    }
}