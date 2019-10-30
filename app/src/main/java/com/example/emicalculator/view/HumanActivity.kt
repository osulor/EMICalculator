package com.example.emicalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emicalculator.Human
import com.example.emicalculator.R
import kotlinx.android.synthetic.main.activity_human.*

class HumanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human)

       val humanIn = intent?.getParcelableExtra("my_human_key") as Human

        humanIn.let { human ->
            val string = "${human.name} has hair color ${human.hairColor}"
            human_textView.text = string
        }
    }
}
