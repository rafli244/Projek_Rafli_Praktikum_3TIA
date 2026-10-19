package com.example.rafli_3tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rafli_3tia.Home.Pertemuan_5.LimaActivity
import com.example.rafli_3tia.Home.Pertemuan_6.EnamActivity
import com.example.rafli_3tia.LginActivity
import com.example.rafli_3tia.R
import com.example.rafli_3tia.databinding.FragmentHome2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHome2Binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        // Menerima data Intent dari halaman Login (jika ada)
        val user = requireActivity().intent.getStringExtra("Username")
        val pass = requireActivity().intent.getStringExtra("Password")

        binding.txtUsername.text = user ?: "Kosong"
        binding.txtPassword.text = pass ?: "Kosong"

        // Tombol untuk memunculkan Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah pesan Snackbar monochrome", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    // Aksi opsional ketika tombol action di snackbar diklik
                }
                .show()
        }

        // Tombol untuk memunculkan AlertDialog
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus Data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // Tambahkan proses hapus data di sini jika diperlukan
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        // Tombol untuk berpindah ke LimaActivity
        binding.btnToLima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }

        binding.btnToEnam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
            startActivity(intent)
        }


        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LginActivity::class.java))
                    requireActivity()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
    }

