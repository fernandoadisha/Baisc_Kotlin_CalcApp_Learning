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

    var memoryList = mutableListOf<Float>()
    var memSlot1: Boolean = false
    var memSlot2: Boolean = false
    var memSlot3: Boolean = false
    var calcCount: Int = 0
    var memPointer: Int = -1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        memoryList.addAll(listOf(0F, 0F, 0F))
    }

    fun clearAction(view: View) {
        NumOneTV.text.clear()
        NumTwoTV.text.clear()
        ResultsTV.text=""
        memoryTV.text=""
        memPointer=-1
        clearVar()
    }

    fun operationAction(view: View) {
        if(view is Button){
            when(view.text){
                "x"-> {
                    if(numberValidation()){
                        answer=numOne*numTwo
                        shownMemResults(answer)
                    }
                    else{
                        clearVar()
                    }
                }
                "/"->{
                    if(numberValidation()){
                        answer=numOne/numTwo
                        shownMemResults(answer)
                    }
                    else{
                        clearVar()
                    }
                }
                "-"->{
                    if(numberValidation()){
                        answer=numOne-numTwo
                        shownMemResults(answer)
                    }
                    else{
                        clearVar()
                    }
                }
                else -> {
                    if(numberValidation()){
                        answer=numOne+numTwo
                        shownMemResults(answer)
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

    private fun shownMemResults(answer: Float){
        ResultsTV.text=answer.toString()
        memoryList[2]=memoryList[1]
        memoryList[1]=memoryList[0]
        memoryList[0]=answer
        calcCount++

        if(calcCount==1)
            memSlot1=true
        else if(calcCount==2)
            memSlot2=true
        else if(calcCount==3)
            memSlot3=true
    }


    fun memoryMinusAction(view: View) {
        if(!memSlot1){
            Toast.makeText(this, "You should do calculations First", Toast.LENGTH_SHORT).show()
        }
        else if(memPointer>0){
            memPointer--
            memoryTV.text=memoryList[memPointer].toString()
        }
        else{
            Toast.makeText(this, "This is the last calculation you did", Toast.LENGTH_SHORT).show()
        }
    }
    fun memoryPlusAction(view: View) {
        if(memSlot1 && memSlot2 && memSlot3) {
            if(memPointer<2){
                memPointer++
                memoryTV.text=memoryList[memPointer].toString()
            }
            else{
                Toast.makeText(this, "Reached to maximum memory level", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            if(!memSlot1){
                Toast.makeText(this, "You should do calculations First", Toast.LENGTH_SHORT).show()
            }
            else if(!memSlot2){
                memPointer++
                memoryTV.text=memoryList[memPointer].toString()
            }
            else{
                memPointer++
                memoryTV.text=memoryList[memPointer].toString()
            }
        }
    }
}