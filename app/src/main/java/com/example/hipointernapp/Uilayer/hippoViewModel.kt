package com.example.hipointernapp.Uilayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.hhrhr.Data.hippoApi
import com.example.hipointernapp.Domain.UserInfoInput
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class hippoViewModel:ViewModel() {
    private var _userInput: MutableLiveData<UserInfoInput> = MutableLiveData<UserInfoInput>()
    val userInput=_userInput

    private  var _details = MutableLiveData("New Data")
    val details: LiveData<String> = _details


    fun gethippodetails() {
        viewModelScope.launch {
            var getDeferredresult= hippoApi.retrofitService.getProperties()
            try {
                var listResult=getDeferredresult.await()

                _details.value="Sucess: ${ listResult.get(0).positions.get(0).name}"
            }
            catch (t:Throwable){
                _details.value="Failure to get data"+t.message
            }

        }
    }

    fun setInternapplication(name:String="No name",note:String="No Note",cv:String="No Cv",email:String="No Email",position:Int=-1,selectperoid:List<Int> = listOf(-1)){
        viewModelScope.launch {
            var getDeferredresult=hippoApi.retrofitService.setapplication(setUserInput(name,note,cv,email,position,selectperoid))
            try {
                var listResult=getDeferredresult.await()

                _details.value="Sucess: ${ listResult.get(0).id}"
            }
            catch (t:Throwable){
                _details.value="Failure to get data"+t.message
            }

        }
    }

    fun setUserInput(name:String="No name",note:String="No Note",cv:String="No Cv",email:String="No Email",position:Int=-1,selectperoid:List<Int> = listOf(-1)): UserInfoInput {
      val userapplication=UserInfoInput(cv,email,name,note,position,selectperoid)
        return userapplication
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}