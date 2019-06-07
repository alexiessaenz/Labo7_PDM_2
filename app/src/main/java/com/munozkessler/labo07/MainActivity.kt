package com.munozkessler.labo07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.munozkessler.labo07.Database.GithubRepo
import com.munozkessler.labo07.ViewModels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val githubRepoViewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)

        activity_main_Button_addRepo.setOnClickListener{
            val name = activity_main_EditText_repoName.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                githubRepoViewModel.insert(GithubRepo(name))
            }
        }

        githubRepoViewModel.getAll().observe(this, Observer { repos ->
            Log.d("LISTA DE REPOS", "---------------------------------")
            for(repo in repos){
                Log.d("LISTA DE REPOS", repo.name)
            }
        })

    }



}
