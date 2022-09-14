package com.alcatras.movieapp.UserOperationsActivities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alcatras.movieapp.Activities.MoviesListActivity
import com.alcatras.movieapp.R
import com.alcatras.movieapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.concurrent.fixedRateTimer


class RegisterFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding:FragmentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()
        //The process of user registiration

        binding.btnSignUp.setOnClickListener {
            val email=binding.tvUserEmailLogin.text.toString()
            val password=binding.tvUserPasswordLogin.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this.context,"Empty",Toast.LENGTH_LONG).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                        val intent=Intent(binding.root.context,MoviesListActivity::class.java)
                        binding.root.context.startActivity(intent)
                        activity?.finish()

                    }
                    .addOnFailureListener {
                        Toast.makeText(this.context,it.localizedMessage,Toast.LENGTH_LONG).show()
                    }
            }
        }
        binding.btnBack.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,LoginFragment())?.commit()

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding=FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }


}