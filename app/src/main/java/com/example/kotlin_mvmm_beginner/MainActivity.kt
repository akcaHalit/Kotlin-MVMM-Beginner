package com.example.kotlin_mvmm_beginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlin_mvmm_beginner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.resultText.text = "0"

        binding.buttonAdd.setOnClickListener{
            val number1Text = binding.number1Text.text.toString()
            val number2Text = binding.number2Text.text.toString()
            val number1 = number1Text.toInt()
            val number2 = number2Text.toInt()
            val result = number1 + number2
            binding.resultText.text = result.toString()
        }

        binding.buttonSub.setOnClickListener{
            val number1Text = binding.number1Text.text.toString()
            val number2Text = binding.number2Text.text.toString()
            val number1 = number1Text.toInt()
            val number2 = number2Text.toInt()
            val result = number1 - number2
            binding.resultText.text = result.toString()
        }

        binding.buttonMult.setOnClickListener{
            val number1Text = binding.number1Text.text.toString()
            val number2Text = binding.number2Text.text.toString()
            val number1 = number1Text.toInt()
            val number2 = number2Text.toInt()
            val result = number1 * number2
            binding.resultText.text = result.toString()
        }

        binding.buttonDiv.setOnClickListener{
            val number1Text = binding.number1Text.text.toString()
            val number2Text = binding.number2Text.text.toString()
            val number1 = number1Text.toInt()
            val number2 = number2Text.toInt()
            val result = number1 / number2
            binding.resultText.text = result.toString()
        }
    }
}