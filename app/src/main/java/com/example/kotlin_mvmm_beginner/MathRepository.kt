package com.example.kotlin_mvmm_beginner

import androidx.lifecycle.MutableLiveData

class MathRepository{

    var mathResult = MutableLiveData<String>().apply { value = "0" }
    fun getSomeMathResult() : MutableLiveData<String>{
        return mathResult
    }
    fun multiply(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 * number2
        mathResult.value = result.toString()
    }

    fun divide(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 / number2
        mathResult.value = result.toString()
    }
    fun add(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 + number2
        mathResult.value = result.toString()

    }
    fun subtract(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 - number2
        mathResult.value = result.toString()
    }


}



