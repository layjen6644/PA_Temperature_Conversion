// Name: Layla Jenkins
// Date: 11/22/2026
// Assignment: 2.4 Performance Assessment: Temperature Conversion App

package com.example.jenkinstemperatureconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add icon to action bar
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.mipmap.ic_launcher)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // Get button and add event handler
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        btnConvert.setOnClickListener {
            val txtTemp = findViewById<EditText>(R.id.txtTemp)
            val enteredTemp = txtTemp.text.toString().toDouble()
            val btnFtoC = findViewById<RadioButton>(R.id.radFtoC)
            val txtResult = findViewById<TextView>(R.id.txtResult)

            if (btnFtoC.isChecked) {
                // converts fahrenheit to celsius of range -100 to 250
                if (enteredTemp >= -100 && enteredTemp <=250 ) {
                    // Conversion formula
                    val tempInCel = (enteredTemp - 32) * 5.0/9.0
                    // displays temp with no decimal
                    val txtTmp = String.format("%.0f", tempInCel)
                    txtResult.text = "$txtTmp Celsius"
                } else {
                    // Show user message that the temp value isn't in range
                    Toast.makeText(this, "Temperature must be between -100 and 250",
                        Toast.LENGTH_LONG).show()
                }
            } else {
                // converts celsius to fahrenheit of range -75 and 125
                if (enteredTemp >= -75 && enteredTemp <= 125) {
                    // Conversion formula
                    val tempInFah = (enteredTemp * 9.0/5.0) + 32
                    // Displays temp in fahrenheit
                    val txtTmp = String.format("%.0f", tempInFah)
                    txtResult.text = "$txtTmp Fahrenheit"
                } else {
                    // show message if temp isn't in range
                    Toast.makeText(this, "Temperature must be between -75 and 125",
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}