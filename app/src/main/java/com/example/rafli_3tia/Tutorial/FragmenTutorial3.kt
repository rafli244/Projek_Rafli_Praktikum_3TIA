package com.example.rafli_3tia.Tutorial

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.rafli_3tia.LginActivity
import com.example.rafli_3tia.R
import com.example.rafli_3tia.databinding.FragmentFragmenTutorial3Binding
import com.example.rafli_3tia.databinding.FragmentHome2Binding


class FragmenTutorial3 : Fragment() {
    private lateinit var _binding: FragmentFragmenTutorial3Binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragmenTutorial3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(requireContext(), LginActivity::class.java))
        }
    }
}