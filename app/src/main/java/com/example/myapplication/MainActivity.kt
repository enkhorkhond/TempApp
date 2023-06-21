package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.calculate_button);

        button1.setOnClickListener {
            Toast.makeText(this, "Hello worlds", Toast.LENGTH_SHORT).show();

            val intent2 = Intent (this,  Page2::class.java);
            startActivity(intent2);
        }
    }
}