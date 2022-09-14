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
import com.alcatras.movieapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth=FirebaseAuth.getInstance()
        binding.btnNext.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,RegisterFragment())?.commit()
        }
        binding.btnSignIn.setOnClickListener {

            val email=binding.tvUserEmailLogin.text.toString()
            val password=binding.tvUserPasswordLogin.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(it.context,"Empty",Toast.LENGTH_LONG).show()
            }
            else{
                auth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                        val intent=Intent(this.context,MoviesListActivity::class.java)
                        this.context?.startActivity(intent)
                        activity?.finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this.context,it.localizedMessage,Toast.LENGTH_LONG).show()
                    }
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(inflater,container,false)

        // Inflate the layout for this fragment
        return binding.root
    }


}