package com.example.moviewapp

import android.R.attr.data
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviewapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        val root: View = binding.root
        val nxtButton = binding.button3
        nxtButton.setOnClickListener { continuePressed()}
        return root
    }

    private fun continuePressed() {
        val passwordField = binding.editTextTextPassword
        val validLenght = passwordField.text.count() > 6
        val containsNumbers = passwordField.text.contains("[0-9]".toRegex())
        val containsLetters = passwordField.text.contains("[A-Za-z]".toRegex())
        if (validLenght && containsNumbers && containsLetters) {
            val root: View = binding.root
            Navigation.findNavController(root).navigate(R.id.action_firstFragment_to_secondFragment)
        } else {
            Toast.makeText(
                activity, "Invalid password",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}