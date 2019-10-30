package com.example.emicalculator.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.emicalculator.Human
import com.example.emicalculator.R
import com.example.emicalculator.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var main_nextButton: Button = findViewById(R.id.next_main)
    }

   fun nextButtonClicked(view: View){

       val intent = Intent(this, PictureActivity::class.java)
       val name = full_name.text.toString()
       intent.putExtra(Constants.INFOS_KEY, name)
       startActivity(intent)
//
//       val humanIntent = Intent(this, HumanActivity::class.java)
//       val myHuman = Human(name,"Dark")
//
//       humanIntent.putExtra("my_human_key",myHuman)
//       startActivity(humanIntent)

    }


}
