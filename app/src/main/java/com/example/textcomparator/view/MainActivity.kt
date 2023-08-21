package com.example.textcomparator.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.textcomparator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.resultant.observe(this){
            binding.resultado.text = it.solution
        }

        binding.buttonComparar.setOnClickListener{
            val text1 = binding.editTexInput1.text.toString()
            val text2 = binding.editTexInput2.text.toString()
            mainViewModel.compareStrings(text1, text2)
        }
    }

}