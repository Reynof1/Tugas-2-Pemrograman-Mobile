package com.example.tugas2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val name = intent.getStringExtra("FULL_NAME")
        val textView = findViewById<TextView>(R.id.tvWelcome)
        textView.text = "Welcome, $name!"
    }
}
