package com.example.emicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.emicalculator.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var main_nextButton: Button = findViewById(R.id.next_main)
    }

   fun nextButtonClicked(view: View){

       intent = Intent(this,PictureActivity::class.java)
       val infos = full_name.text.toString()
       intent.putExtra(Constants.INFOS_KEY, infos)
       startActivity(intent)

    }


}
