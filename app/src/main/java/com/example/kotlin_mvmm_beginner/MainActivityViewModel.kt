package com.example.kotlin_mvmm_beginner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class MainActivityViewModel : ViewModel() {

    var calculatedResult = MutableLiveData<String>()

    var mRepo = MathRepository()
    init {
        calculatedResult = mRepo.getSomeMathResult()
    }

    fun clickButtonMultiply(number1Text: String, number2Text: String){
        mRepo.multiply(number1Text,number2Text)
    }
    fun clickButtonDivide(number1Text: String, number2Text: String){
        mRepo.divide(number1Text,number2Text)
    }
    fun clickButtonAdd(number1Text: String, number2Text: String){
        mRepo.add(number1Text,number2Text)
    }
    fun clickButtonSubtract(number1Text: String, number2Text: String){
        mRepo.subtract(number1Text,number2Text)
    }


    // Before Repository:

    /*
    fun clickButtonMultiply(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 * number2
        //binding.resultText.text = result.toString()
        // calculatedResult = result.toString()
        calculatedResult.value = result.toString()

    }

    fun clickButtonDivide(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 / number2
        //binding.resultText.text = result.toString()
        // calculatedResult = result.toString()
        calculatedResult.value = result.toString()
    }
    fun clickButtonAdd(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 + number2
        //binding.resultText.text = result.toString()
        // calculatedResult = result.toString()
        calculatedResult.value = result.toString()

    }
    fun clickButtonSubtract(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 - number2
        //binding.resultText.text = result.toString()
        // calculatedResult = result.toString()
        calculatedResult.value = result.toString()
    }
*/
}

/*
// Before Live Data:        var calculatedResult = "0"
var calculatedResult = MutableLiveData<String>()

init {
    calculatedResult = MutableLiveData<String>("0")
}
*/


