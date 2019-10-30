package com.example.emicalculator.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.emicalculator.R
import com.example.emicalculator.util.Constants
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    var loan: Int = 0
    var rate: Int = 0
    var year: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        loan_seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                loan =  progress
                loan_textView.text = "LOAN AMOUNT: " + (loan * 1000).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        years_seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //  value = progress
                 year = progress
                years_textView.text = "YEARS: " + year.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        interest_seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                 rate = progress
                interest_textView.text = "INTEREST RATE: " + rate.toString() + "%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }


    fun calculateButtonClicked(view: View){

        val emi =((loan * rate) * (1 + rate))

        val em1 = Math.pow((1.0 + interest_seekBar.progress),years_seekBar.progress.toDouble())

        val emi2 = Math.pow((1.0 + interest_seekBar.progress),((years_seekBar.progress.toDouble()) - 1.0))

        val emiFinal = (emi * em1)/emi2



        intent = Intent(this, SummaryActivity::class.java)
        val emiVal = emiFinal.toString()
        intent.putExtra(Constants.EMI_KEY, emiVal)
        startActivity(intent)

    }
}
