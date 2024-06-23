package com.example.kotlin_mvmm_beginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.kotlin_mvmm_beginner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivityObject  = this

        // Not Necessary Now        binding.resultText.text = "0"

        // Before ViewModel : binding.calculatedResult = "0"

        // Before the Live Data: binding.calculatedResult = viewModel.calculatedResult

        viewModel.calculatedResult.observe(this,  { lambdaresult ->
            binding.calculatedResult = lambdaresult
        })

        /* Not Necessary Now binding.buttonAdd.setOnClickListener{} binding.buttonSub.setOnClickListener{} binding.buttonMult.setOnClickListener{} binding.buttonDiv.setOnClickListener{} */
    }

    fun clickButtonMultiply(number1Text: String, number2Text: String){
        viewModel.clickButtonMultiply(number1Text,number2Text)
    }

    fun clickButtonDivide(number1Text: String, number2Text: String){
        viewModel.clickButtonDivide(number1Text,number2Text)
    }
    fun clickButtonAdd(number1Text: String, number2Text: String){
        viewModel.clickButtonAdd(number1Text,number2Text)
    }
    fun clickButtonSubtract(number1Text: String, number2Text: String){
        viewModel.clickButtonSubtract(number1Text,number2Text)
    }

    // Before Live Data:
    /*
    fun clickButtonMultiply(number1Text: String, number2Text: String){
        viewModel.clickButtonMultiply(number1Text,number2Text)
        binding.calculatedResult = viewModel.calculatedResult
    }

    fun clickButtonDivide(number1Text: String, number2Text: String){
        viewModel.clickButtonDivide(number1Text,number2Text)
        binding.calculatedResult = viewModel.calculatedResult
    }
    fun clickButtonAdd(number1Text: String, number2Text: String){
        viewModel.clickButtonAdd(number1Text,number2Text)
        binding.calculatedResult = viewModel.calculatedResult
    }
    fun clickButtonSubtract(number1Text: String, number2Text: String){
        viewModel.clickButtonSubtract(number1Text,number2Text)
        binding.calculatedResult = viewModel.calculatedResult
    }
    */
    /*          Before ViewModel
    fun clickButtonMultiply(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 * number2
        //binding.resultText.text = result.toString()
        binding.calculatedResult = result.toString()
    }
    fun clickButtonDivide(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 / number2
        //binding.resultText.text = result.toString()
        binding.calculatedResult = result.toString()
    }
    fun clickButtonAdd(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 + number2
        //binding.resultText.text = result.toString()
        binding.calculatedResult = result.toString()
    }
    fun clickButtonSubtract(number1Text: String, number2Text: String){
        val number1 = number1Text.toInt()
        val number2 = number2Text.toInt()
        val result = number1 - number2
        //binding.resultText.text = result.toString()
        binding.calculatedResult = result.toString()
    }

     */

}


