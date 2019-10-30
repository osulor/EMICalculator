package com.example.emicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emicalculator.util.Constants
import kotlinx.android.synthetic.main.activity_picture.*
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        intent?.getStringExtra(Constants.EMI_KEY)?.let { message ->
            emiVal_textView.text = "$".plus(message)
        }
    }
}
