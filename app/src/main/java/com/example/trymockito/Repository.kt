package com.example.trymockito

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class Repository{

    open lateinit var myVar: String

    private val _myList = MutableLiveData<List<String>>()
    val myList: LiveData<List<String>>
        get() = _myList

    init {
        voidMethod("Execute", "Method")
        //assignListToLiveData()
    }

    open fun returnString(): String = "Repository String"

    open fun voidMethod(text1: String, text2: String){
        myVar = "$text1 $text2"
    }

    fun assignListToLiveData(){
        _myList.value = liveDataList()
    }

    open fun liveDataList(): List<String> = listOf(
        "Uno",
        "Dos",
        "Tres",
        "Cuatro"
    )

}

class MyViewModel{

}