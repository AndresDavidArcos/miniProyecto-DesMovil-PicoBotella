package com.example.picobotellaequipo6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.picobotellaequipo6.model.Challenges
import com.example.picobotellaequipo6.repository.ChallengesRepository
import kotlinx.coroutines.launch

class ChallengesViewModel(application: Application):AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val challengesRepository = ChallengesRepository(context)

    private val _listInventory = MutableLiveData<MutableList<Challenges>>()

    val listInventory: LiveData<MutableList<Challenges>> get() = _listInventory


    fun saveInventory(challenges: Challenges){
        viewModelScope.launch {
            challengesRepository.saveInventory(challenges)
        }
    }


    fun getListInvetory(){
        viewModelScope.launch {
            _listChallenge.value = challengesRepository.getListInventory()

        }
    }
    fun updateChallenge(challenge: Challenges){
        viewModelScope.launch {
            challengesRepository.updateRepositoy(challenge)
        }
    }
}