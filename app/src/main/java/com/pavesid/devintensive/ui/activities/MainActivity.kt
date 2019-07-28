package com.pavesid.devintensive.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.pavesid.devintensive.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val COLOR_MODE_KEY = "COLOR_MODE_KEY"
    }

    private var editText : EditText? = null
    private var redButton : Button? = null
    private var greenButton : Button? = null
    private var colorMode : Int = 0

//    init {
//        redButton = findViewById(R.id.red_btn)
//        greenButton = findViewById(R.id.green_btn)
//        editText = findViewById(R.id.textView)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("M_MainActivity", "onCreate")

        redButton = findViewById(R.id.red_btn)
        greenButton = findViewById(R.id.green_btn)
        editText = findViewById(R.id.textView)

        redButton?.setOnClickListener(this)
        greenButton?.setOnClickListener(this)

        if(savedInstanceState == null){
            //Активити впервые запускается
        } else {
            colorMode = savedInstanceState.getInt(COLOR_MODE_KEY)
            Log.d("M_MainActivity", "$colorMode")
            when(colorMode){
                Color.RED -> editText?.setBackgroundColor(Color.RED)
                Color.GREEN -> editText?.setBackgroundColor(Color.GREEN)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("M_MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("M_MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("M_MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("M_MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("M_MainActivity", "onDestroy")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.green_btn -> {
                editText?.setBackgroundColor(Color.GREEN)
                colorMode = Color.GREEN
            }
            R.id.red_btn -> {
                editText?.setBackgroundColor(Color.RED)
                colorMode = Color.RED
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("M_MainActivity", "onSaveInstanceState")
        outState.putInt(COLOR_MODE_KEY, colorMode)
    }
}
