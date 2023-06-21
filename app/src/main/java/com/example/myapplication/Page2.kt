package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.os.Bundle

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        var button2  = findViewById<Button>(R.id.button2);
        button2.setOnClickListener {
            val intent1 = Intent (this,  MainActivity::class.java);
            startActivity(intent1);
        }
    }
}