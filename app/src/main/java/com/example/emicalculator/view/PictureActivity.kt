package com.example.emicalculator.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.example.emicalculator.R
import com.example.emicalculator.util.Constants
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        intent?.getStringExtra(Constants.INFOS_KEY)?.let { message ->
            text_view.text = message
        }

        picture_button.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callCameraIntent.resolveActivity(packageManager) != null){
                startActivityForResult(callCameraIntent,CAMERA_REQUEST_CODE)
            }
        }


    }

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK && data != null){
                    imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this,"Unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun nextSecondButtonClicked(view: View){

        intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)

    }
}
