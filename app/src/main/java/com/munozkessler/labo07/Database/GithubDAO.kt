package com.munozkessler.labo07.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDAO {

    @Query("SELECT * FROM repos")
    fun getAllRepos():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: GithubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()


}