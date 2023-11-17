package com.example.picobotellaequipo6.repository

import android.content.Context
import com.example.picobotellaequipo6.data.ChallengesDB
import com.example.picobotellaequipo6.data.ChallengesDao
import com.example.picobotellaequipo6.model.Challenges
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChallengesRepository(val context:Context) {
    private var  challengesDao: ChallengesDao = ChallengesDB.getDatabase(context).challengesDao()


    suspend fun saveInventory(challenges: Challenges){
        withContext(Dispatchers.IO){
            challengesDao.saveInventory(challenges)
        }
    }
    suspend fun getListInventory():MutableList<Challenges>{
        return withContext(Dispatchers.IO){
            challengesDao.getListInventory()
        }
    }

}