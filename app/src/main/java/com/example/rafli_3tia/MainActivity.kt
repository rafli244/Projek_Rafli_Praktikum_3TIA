package com.example.rafli_3tia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rafli_3tia.Pertemuan_5.LimaActivity
import com.example.rafli_3tia.Pertemuan_6.EnamActivity
import com.example.rafli_3tia.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur Window Insets agar padding aman dari Status Bar & Navigation Bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        // Menerima data Intent dari halaman Login (jika ada)
        val user = intent.getStringExtra("Username")
        val pass = intent.getStringExtra("Password")

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
            MaterialAlertDialogBuilder(this)
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
            val intent = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intent)
        }

        binding.btnToEnam.setOnClickListener {
            val intent = Intent(this@MainActivity, EnamActivity::class.java)
            startActivity(intent)
        }


        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(this, LginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }
}