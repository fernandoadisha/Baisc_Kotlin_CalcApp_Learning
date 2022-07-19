package com.example.simplepersonalcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var answer: Int = 0

    var numOne: Float = 0F
    var numTwo: Float = 0F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clearAction(view: View) {
        NumOneTV.text.clear()
        NumTwoTV.text.clear()
        ResultsTV.text=""
    }

    fun operationAction(view: View) {
        if(view is Button){
            when(view.text){
                "x"-> {
                    numberValidation()
                }
                "/"->{
                    numberValidation()
                }
                "-"->{
                    numberValidation()
                }
                else -> {
                    numberValidation()
                }
            }
        }
        
    }

    private fun numberValidation() {
        numOne = (NumOneTV.text).toFloat()
    }
}