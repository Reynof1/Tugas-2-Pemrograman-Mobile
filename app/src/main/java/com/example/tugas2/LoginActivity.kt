package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.etLoginUsername)
        val password = findViewById<EditText>(R.id.etLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegisterLink = findViewById<TextView>(R.id.tvRegisterLink) // Tambahkan ini

        // Login logic
        btnLogin.setOnClickListener {
            val inputUser  = username.text.toString()
            val inputPass = password.text.toString()

            val prefs = getSharedPreferences("user", MODE_PRIVATE)
            val savedUser  = prefs.getString("username", "")
            val savedPass = prefs.getString("password", "")

            if (inputUser == savedUser && inputPass == savedPass) {
                val fullName = prefs.getString("fullName", "")
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("FULL_NAME", fullName)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        // Tambahkan aksi klik untuk pindah ke halaman Register
        tvRegisterLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
