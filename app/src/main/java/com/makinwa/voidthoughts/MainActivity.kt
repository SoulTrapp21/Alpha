package com.makinwa.voidthoughts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linearlayout)

        val zero = findViewById<TextView>(R.id.zero)
        val plus = findViewById<TextView>(R.id.addition)
        val minus = findViewById<TextView>(R.id.subtraction)
        val multiply = findViewById<TextView>(R.id.multiplication)
        val divide = findViewById<TextView>(R.id.division)
        val one = findViewById<TextView>(R.id.one)
        val two = findViewById<TextView>(R.id.two)
        val three = findViewById<TextView>(R.id.three)
        val four = findViewById<TextView>(R.id.four)
        val five = findViewById<TextView>(R.id.five)
        val six = findViewById<TextView>(R.id.six)
        val seven = findViewById<TextView>(R.id.seven)
        val eight = findViewById<TextView>(R.id.eight)
        val nine = findViewById<TextView>(R.id.nine)
        val equals = findViewById<TextView>(R.id.equals)
        val cleartext = findViewById<TextView>(R.id.clear_text)
        val delete = findViewById<TextView>(R.id.AC)
        val decimal = findViewById<TextView>(R.id.decimal_point)
        val result = findViewById<TextView>(R.id.result)
        val percent = findViewById<TextView>(R.id.percentage)
        val editText = findViewById<TextView>(R.id.edit)

        fun addFun(x : TextView){
            val edit = editText
            val input = x.text.toString()
            editText.text = edit.text.toString() + input
        }

        zero.setOnClickListener {
            addFun(zero)
        }
        one.setOnClickListener {
            addFun(one)
        }
        two.setOnClickListener {
            addFun(two)
        }
        three.setOnClickListener {
            addFun(three)
        }
        four.setOnClickListener {
            addFun(four)
        }
        five.setOnClickListener {
            addFun(five)
        }
        six.setOnClickListener {
            addFun(six)
        }
        seven.setOnClickListener {
            addFun(seven)
        }
        eight.setOnClickListener {
            addFun(eight)
        }
        nine.setOnClickListener {
            addFun(nine)
        }
        plus.setOnClickListener {
            addFun(plus)
        }
        minus.setOnClickListener {
            addFun(minus)
        }
        divide.setOnClickListener {
            addFun(divide)
        }
        multiply.setOnClickListener {
            addFun(multiply)
        }
        percent.setOnClickListener {
            addFun(percent)
        }
        decimal.setOnClickListener {
            addFun(decimal)
        }
        delete.setOnClickListener {
            val edit = editText
            val result = result
            edit.text = ""
            result.text = ""
        }
        cleartext.setOnClickListener {
            editText.text = editText.text.dropLast(1)
        }
        cleartext.setOnLongClickListener {
            editText.text = ""
            result.text = ""
            true
        }
        equals.setOnClickListener {
            val edit = editText.text

            if (edit.isBlank()) return@setOnClickListener

            val listOfOperators = edit.split("((?<=[+\\-/()%x])|(?=[+\\-/()%x]))".toRegex())


            println(listOfOperators)

            var num: Double = 0.0

            listOfOperators.forEachIndexed { index, items ->
                when(index){
                    0 ->{
                        num = items.trim().toDouble()
                    }
                }
                when(items){
                    "x" -> {num *= listOfOperators[index+1].trim().toDouble()}
                    "+" -> {num += listOfOperators[index+1].trim().toDouble()}
                    "-" -> {num -= listOfOperators[index+1].trim().toDouble()}
                    "/" -> {num /= listOfOperators[index+1].trim().toDouble()}
                    "%" -> {num *= listOfOperators[index+1].trim().toDouble()
                        num*=100
                    }
                }
            }
            result.text = num.toString().dropLast(2)
        }
    }

}