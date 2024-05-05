package com.example.pc_wilfredoramos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        btnCalcular.setOnClickListener {
            val promedio = calcularPromedio()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("PROMEDIO", promedio)
            startActivity(intent)
        }
    }

    private fun calcularPromedio(): Double {
        val n1 = nota1.text.toString().toDouble()
        val n2 = nota2.text.toString().toDouble()
        val n3 = nota3.text.toString().toDouble()
        return (n1 + n2 + n3) / 3
    }
}

