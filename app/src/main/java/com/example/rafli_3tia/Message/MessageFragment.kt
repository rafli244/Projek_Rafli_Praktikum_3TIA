package com.example.rafli_3tia.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.rafli_3tia.databinding.FragmentMessage2Binding

class MessageFragment : Fragment() {

    private lateinit var _binding: FragmentMessage2Binding
    private val binding get() = _binding!!

    private val messageList = listOf(
        Messagemodel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1"),
        Messagemodel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2"),
        Messagemodel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3"),
        Messagemodel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4"),
        Messagemodel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5"),
        Messagemodel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6"),
        Messagemodel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7"),
        Messagemodel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8"),
        Messagemodel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9"),
        Messagemodel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessage2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }
}