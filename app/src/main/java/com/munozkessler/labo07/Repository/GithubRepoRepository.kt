package com.munozkessler.labo07.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.munozkessler.labo07.Database.GithubDAO
import com.munozkessler.labo07.Database.GithubRepo

class GithubRepoRepository(private val repoDao: GithubDAO) {

    @WorkerThread
    suspend fun insert(repo: GithubRepo) = repoDao.insert(repo)

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}