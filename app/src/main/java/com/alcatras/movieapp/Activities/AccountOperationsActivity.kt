package com.alcatras.movieapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alcatras.movieapp.R
import com.alcatras.movieapp.UserOperationsActivities.LoginFragment
import com.google.firebase.auth.FirebaseAuth

class AccountOperationsActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_operations)
        putLoginFragment()
        auth=FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
            val intent= Intent(this,MoviesListActivity::class.java)
            startActivity(intent)
        }
    }
    fun putLoginFragment()
    {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,LoginFragment()).commit()

    }
}