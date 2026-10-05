package com.example.rafli_3tia

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Toast
import com.example.rafli_3tia.databinding.ActivityLginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
class LginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.editTextText)
//        val password : EditText = findViewById(R.id.editTextTextPassword)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            val user = binding.editTextText.text.toString()
            val psw = binding.editTextTextPassword.text.toString()

            intent.putExtra("Username", user)
            intent.putExtra("Password", psw)
            Log.d("Output", "Username: $user Password $psw")
            Toast.makeText(this, "Username $user Password: $psw", Toast.LENGTH_LONG).show()

            startActivity(intent)
        }

    }

    }
