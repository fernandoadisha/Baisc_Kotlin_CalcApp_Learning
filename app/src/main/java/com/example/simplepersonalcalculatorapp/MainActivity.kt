package com.example.simplepersonalcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var answer: Float = 0F

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
        clearVar()
    }

    fun operationAction(view: View) {
        if(view is Button){
            when(view.text){
                "x"-> {
                    if(numberValidation()){
                        answer=numOne*numTwo
                        ResultsTV.text=answer.toString()
                    }
                    else{
                        clearVar()
                    }
                }
                "/"->{
                    if(numberValidation()){
                        answer=numOne/numTwo
                        ResultsTV.text=answer.toString()
                    }
                    else{
                        clearVar()
                    }
                }
                "-"->{
                    if(numberValidation()){
                        answer=numOne-numTwo
                        ResultsTV.text=answer.toString()
                    }
                    else{
                        clearVar()
                    }
                }
                else -> {
                    if(numberValidation()){
                        answer=numOne+numTwo
                        ResultsTV.text=answer.toString()
                    }
                    else{
                        clearVar()
                    }
                }
            }
        }
        
    }

    private fun numberValidation(): Boolean {
        if(NumOneTV.text.toString().isNotEmpty() && NumTwoTV.text.toString().isNotEmpty()){
            val numOneHolder = NumOneTV.text.toString()
            val numTwoHolder = NumTwoTV.text.toString()
            if(numOneHolder.isDigitsOnly() && numTwoHolder.isDigitsOnly()){
                numOne = numOneHolder.toFloat()
                numTwo = numTwoHolder.toFloat()
                return true
            }
            else {
                Toast.makeText(this, "Input Should only be Numbers", Toast.LENGTH_SHORT).show()
                return false
            }

        }
        else {
            Toast.makeText(this,"Fill all Above", Toast.LENGTH_SHORT).show()
            return false
        }


    }

    private fun clearVar(){
        numOne=0F
        numTwo=0F
        ResultsTV.text=""
    }
}