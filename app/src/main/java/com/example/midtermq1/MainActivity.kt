package com.example.midtermq1
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1EditText: EditText = findViewById(R.id.editTextNumber1)
        val number2EditText: EditText = findViewById(R.id.editTextNumber2)
        val operationSpinner: Spinner = findViewById(R.id.operationSpinner)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val num1 = number1EditText.text.toString().toDoubleOrNull()
            val num2 = number2EditText.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (operation) {
                "Addition" -> num1 + num2
                "Subtraction" -> num1 - num2
                "Multiplication" -> num1 * num2
                "Division" -> {
                    if (num2 == 0.0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    } else {
                        num1 / num2
                    }
                }
                else -> 0.0
            }

            resultTextView.text = "Result: $result"
        }
    }
}