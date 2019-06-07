package com.munozkessler.labo07.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class GithubRoomDB: RoomDatabase() {

    //returns the dao for that repo
    abstract fun repoDao(): GithubDAO

    companion object{
        private var INSTANCE: GithubRoomDB? = null

        fun getInstance(appContext: Context): GithubRoomDB{
            val tempInstance = INSTANCE
            // if instance already exists, return that instance
            if(tempInstance != null) return tempInstance

            //synchronized is so that nothing else touches the DB until it finishes building
            synchronized(this){
                //creates the database
                val instance = databaseBuilder(appContext, GithubRoomDB::class.java, "GithubRepoDB").build()
                // it assigns it to the static instance
                INSTANCE = instance
                //returns the created instance to the user.
                return instance
            }
        }
    }


}