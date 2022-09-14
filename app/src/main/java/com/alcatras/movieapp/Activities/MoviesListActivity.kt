package com.alcatras.movieapp.Activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.alcatras.movieapp.MovieListFragments.MovieTypeFragment
import com.alcatras.movieapp.R
import com.google.firebase.auth.FirebaseAuth

class MoviesListActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        auth= FirebaseAuth.getInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,MovieTypeFragment()).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.signOut){
            val alertDialog=AlertDialog.Builder(this)
            alertDialog.setMessage("Are yo sure")
                .setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int ->
                    auth.signOut()
                    val intent= Intent(this,AccountOperationsActivity::class.java)
                    startActivity(intent)
                    finish()
                })
                .setNegativeButton("No",null)
                .show()


        }
        return super.onOptionsItemSelected(item)
    }
}