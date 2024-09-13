package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    private lateinit var propertyValueEditText: EditText
    private lateinit var loanAmountEditText: EditText
    private lateinit var loanTermEditText: EditText
    private lateinit var interestRateEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        propertyValueEditText = findViewById(R.id.editText)
        loanAmountEditText = findViewById(R.id.editText2)
        loanTermEditText = findViewById(R.id.editText3)
        interestRateEditText = findViewById(R.id.editText4)
        calculateButton = findViewById(R.id.button)
        resultTextView = findViewById(R.id.textView11)

        calculateButton.setOnClickListener {
            calculateMonthlyInstallment()
        }
    }

    private fun calculateMonthlyInstallment() {
        val propertyValue = propertyValueEditText.text.toString().toDouble()
        val loanAmount = loanAmountEditText.text.toString().toDouble()
        val loanTerm = loanTermEditText.text.toString().toInt()
        val interestRate = interestRateEditText.text.toString().toDouble()

        val monthlyInterestRate = (interestRate / 12) / 100
        val months = loanTerm * 12

        val monthlyInstallment = loanAmount * Math.pow(1 + monthlyInterestRate, months.toDouble()) * monthlyInterestRate / (Math.pow(1 + monthlyInterestRate, months.toDouble()) - 1)

        resultTextView.text = "Paga cuotas mensuales de ${String.format("%.2f", monthlyInstallment)} por mes."
    }
}
