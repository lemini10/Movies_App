package com.example.moviewapp

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.moviewapp.databinding.FragmentSecondBinding
import com.example.moviewapp.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val movie = requireArguments().getString("title")
        var movieSelected = ""
        if (movie == "Wall-E") {
            movieSelected = "walle"
        }  else if (movie == "Ratatouille") {
            movieSelected = "rata"
        }
        else if (movie == "Up") {
            movieSelected = "up"
        }
        else if (movie == "Coco") {
            movieSelected = "coco"
        }
        else if (movie == "Aladdin") {
            movieSelected = "ala"
        }
        _binding = FragmentThirdBinding.inflate(inflater, container,false)
        val root: View = binding.root
        val videoViewer = binding.videoView
        val videoPath = "android.resource://" + requireActivity().packageName +"/raw/${movieSelected}"
        val uri = Uri.parse(videoPath)
        videoViewer.setVideoURI(uri)
        val mediaController: MediaController = MediaController(root.context)
        mediaController.setAnchorView(videoViewer)
        videoViewer.setMediaController(mediaController)
        videoViewer.start()
        return root
    }
}