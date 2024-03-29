package com.felipevieira.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            handleCalculate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    private fun handleCalculate() {
        if (isValid()) {

            try {

                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val result: Float = ((distance * price) / autonomy)
                //val realresult: Double = String.format("%.2f", result).toDouble()

                textResult.text = "R$ $result"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.valoresvalidos), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.valoresvalidos), Toast.LENGTH_LONG).show()
        }
    }

    private fun isValid(): Boolean {
        return editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() !="0"
    }
}
