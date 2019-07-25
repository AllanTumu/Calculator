package com.mea.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var equalevent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun btNumberEvent(view:View){
        if (newop){
            ShowNumber.setText("")
            btDot.isClickable=true
            btPlusOrMinus.isClickable=true
        }
        newop = false
        equalevent = false
        val btSelect = view as Button
        var btClickValue:String=ShowNumber.text.toString()
        when (btSelect.id) {
            bt0.id -> {
                btClickValue+="0"
            }
            bt1.id ->{
                btClickValue+="1"
            }
            bt2.id -> {
                btClickValue+="2"
            }
            bt3.id -> {
                btClickValue+="3"
            }
            bt4.id -> {
                btClickValue+="4"
            }
            bt5.id -> {
                btClickValue+="5"
            }
            bt6.id -> {
                btClickValue+="6"
            }
            bt7.id -> {
                btClickValue+="7"
            }
            bt8.id -> {
                btClickValue+="8"
            }
            bt9.id -> {
                btClickValue+="9"
            }
            btDot.id -> {
                btClickValue+="."
                btDot.isClickable=false
            }
            btPlusOrMinus.id -> {
                btClickValue="-"+btClickValue
                btPlusOrMinus.isClickable=false
            }

        }
        ShowNumber.setText(btClickValue)
    }

    var op = ""
    var oldnumber = ""
    var newop = true
    fun btOpEvent (view:View) {
        var btSelect = view as Button
        when (btSelect.id){
            btdiv.id -> {
                op = "/"
            }

            btMul.id -> {
                op = "*"
            }

            btMinus.id -> {
                op = "-"
            }

            btPlus.id -> {
                op = "+"
            }
            btPercent.id -> {
                op = "%"
            }

        }
        oldnumber = ShowNumber.text.toString()
        newop  = true
    }

    fun btEqualEvent (view: View){
        if (equalevent) return
        val btSelect = view as Button
        val newNumber = ShowNumber.text.toString()
        var answer:Double?=null
        when(op){
            "/" -> {
                answer = oldnumber.toDouble()/newNumber.toDouble()
            }
            "*" -> {
                answer = oldnumber.toDouble()*newNumber.toDouble()
            }
            "-" -> {
                answer = oldnumber.toDouble() - newNumber.toDouble()
            }
            "+" ->{
                answer = oldnumber.toDouble() + newNumber.toDouble()
            }
            "%" ->{
                answer = oldnumber.toDouble() / 100
            }
            "" -> {
                answer = 0.0
            }
        }

        ShowNumber.setText(answer.toString())
        newop = true
        equalevent = true
    }
    fun btClear (view: View){
        val btSelect = view as Button
        when (btSelect.id) {
            btClear.id-> {
                ShowNumber.setText("0")
                btDot.isClickable=true
                btPlusOrMinus.isClickable=true
                newop = true
                oldnumber = ""
                op=""
            }
        }
    }

}

