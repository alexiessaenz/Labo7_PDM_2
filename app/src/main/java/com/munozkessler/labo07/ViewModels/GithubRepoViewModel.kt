package com.munozkessler.labo07.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.munozkessler.labo07.Database.GithubRepo
import com.munozkessler.labo07.Database.GithubRoomDB
import com.munozkessler.labo07.Repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app) {

    private val githubRepoRepo : GithubRepoRepository

    init {
        //get the Dao and either create the databse or get the instance this dao is just a placeholder for creating the repo
        val repoDao = GithubRoomDB.getInstance(app).repoDao()
        githubRepoRepo = GithubRepoRepository(repoDao)
    }

    //must be launch and here is where all the suspended functions are called
    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        //calls the insert method from the Repository which then calls the insert method from the Dao
        githubRepoRepo.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = githubRepoRepo.getAll()

    fun nuke() = githubRepoRepo.nuke()

}