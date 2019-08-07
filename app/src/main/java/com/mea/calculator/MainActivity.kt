package com.mea.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    var op = ""
    var oldnumber:String = ""
    var newNumber:String = ""
    var newop = true
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
                btClickValue="-" +btClickValue
                btPlusOrMinus.isClickable=false
            }
        }
        ShowNumber.setText(btClickValue)
    }


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
            btDot.id -> {
                op = "."
            }

        }
        oldnumber = ShowNumber.text.toString()
            if (oldnumber.equals("")){
                oldnumber = "0"
            } else if (oldnumber.equals("-")){
                oldnumber = "0"
            } else if (oldnumber.equals(".")){
                oldnumber = "0"
            }
            else {
                oldnumber.toDouble()
            }
        newop  = true
    }

    fun btEqualEvent (view: View){
         newNumber = ShowNumber.text.toString()
        if (newNumber.equals("")){
            newNumber = "0"
        } else if (newNumber.equals("-")){
            newNumber = "0"
        } else if (newNumber.equals(".")){
            newNumber = "0"
        }
        else {
            newNumber.toDouble()
        }
        if (equalevent) return
        var answer:Double?=null
        when(op){
            "/" -> {
                answer = oldnumber.toDouble()/ newNumber.toDouble()
            }
            "*" -> {
                answer = oldnumber.toDouble()* newNumber.toDouble()
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
            "." -> {
                answer = 0.0
            }
        }
        if (answer.toString().equals("NaN")){
            answer = 0.0
        }else {
            answer = answer.toString().toDouble()
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
                oldnumber = "0"
                op=""
            }
        }
    }
    fun btBckSpace (view: View){
        var dis = ShowNumber.text.toString()
        val btSelect = view as Button
        when (btSelect.id){
            btBckSpace.id -> {
                if (dis.length >1){
                   dis = dis.substring(0,dis.length -1)
                    ShowNumber.setText(dis)
                }
                else if (dis.length <= 1){
                    ShowNumber.setText("")
                }
            }
        }
    }

}


