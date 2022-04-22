package com.example.moviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewapp.databinding.FragmentFirstBinding
import com.example.moviewapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

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
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        return root
    }
}