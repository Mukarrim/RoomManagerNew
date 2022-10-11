package com.tes.eat.anywhere.roommanager.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.roommanager.model.Repository.Repository
import com.tes.eat.anywhere.roommanager.model.remote.virginmoney.EmployeeApi
import com.tes.eat.anywhere.roommanager.model.data.people.People
import com.tes.eat.anywhere.roommanager.model.data.people.PeopleItem
import com.tes.eat.anywhere.roommanager.model.repository.Repository
import com.tes.eat.anywhere.roommanager.util.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewmodel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var currentData= PeopleItem()
    private val _people = MutableLiveData<People>()
    val people: LiveData<People> = _people

    // API call to fetch the data
    fun getPeople() {
        CoroutineScope(Dispatchers.Main).launch {
            val peopleList = repository.getPeople()

            // verify if the response was successful
            if (peopleList.isSuccessful) {
                _people.postValue(peopleList.body())
            } else {
                _people.postValue(People())
            }
        }
    }
}