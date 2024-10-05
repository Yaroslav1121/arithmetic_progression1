package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFirstTerm = findViewById<EditText>(R.id.inputFirstTerm)
        val inputDifference = findViewById<EditText>(R.id.inputDifference)
        val inputNumOfTerms = findViewById<EditText>(R.id.inputNumOfTerms)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            // Отримуємо введені значення
            val a = inputFirstTerm.text.toString().toDoubleOrNull()
            val d = inputDifference.text.toString().toDoubleOrNull()
            val n = inputNumOfTerms.text.toString().toIntOrNull()

            // Перевіряємо, чи всі поля заповнені
            if (a != null && d != null && n != null && n > 0) {
                // Обчислюємо суму елементів арифметичної прогресії
                val sum = (n / 2.0) * (2 * a + (n - 1) * d)
                tvResult.text = "Сума: ${round(sum * 100) / 100}"
            } else {
                tvResult.text = "Будь ласка, введіть коректні значення"
            }
        }
    }
}
