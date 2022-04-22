package com.example.moviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewapp.databinding.FragmentFirstBinding
import com.example.moviewapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(), MovieHandler {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var managerLayout: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        managerLayout = LinearLayoutManager(this.context)
        _binding = FragmentSecondBinding.inflate(inflater, container,false)
        val root: View = binding.root
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = managerLayout
        adapter = RecyclerAdapter(movieHandler = this)
        recyclerView.adapter = adapter

        return root
    }

    override fun movieSelected(title: String, genre: String) {
        val root: View = binding.root
        Navigation.findNavController(root).navigate(R.id.action_secondFragment_to_thirdFragment, Bundle().apply {
                putString("title", title)
        })
    }
}

interface MovieHandler {
    fun movieSelected(title: String, genre: String)
}