package com.example.textcomparator.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.textcomparator.model.Solve
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val resultant: LiveData<Solve> get() = _resultant
    private val _resultant = MutableLiveData<Solve>(Solve(""))

    fun compareStrings(text1: String, text2: String) {
        val result: String = if(text1 == text2) {
            "Ambas cadenas son iguales"
        }else{
            "Las cadenas no son iguales"
        }
        updateSolve(result)
    }

    private fun updateSolve(result: String){
        viewModelScope.launch {
            _resultant.value = Solve(result)
        }
    }

}