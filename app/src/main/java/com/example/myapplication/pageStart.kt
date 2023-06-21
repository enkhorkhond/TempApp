package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader


class pageStart : AppCompatActivity() {

    private val FILE_NAME = "example.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_start)

        var buttonStart  = findViewById<Button>(R.id.buttonStart);

        var buttonSave  = findViewById<Button>(R.id.buttonSave);
        var buttonLoad  = findViewById<Button>(R.id.buttonLoad);
        var txtLoad  = findViewById<TextView>(R.id.txtLoad);

        buttonStart.setOnClickListener {
            val intentStart = Intent (this,  MainActivity::class.java);
            startActivity(intentStart);
        }

        buttonLoad.setOnClickListener {
            var fis: FileInputStream? = null

            try {
                fis = openFileInput(FILE_NAME)
                val isr = InputStreamReader(fis)
                val br = BufferedReader(isr)
                val text : String =br.readLine();
                txtLoad.setText(text);
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (fis != null) {
                    try {
                        fis.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

        }

        buttonSave.setOnClickListener {
            val text: String = "lkdfjlsdjf hkdhfk jhf khjfk";
            var fos: FileOutputStream? = null

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
                fos.write(text.toByteArray())

                Toast.makeText(this, "Saved to" + filesDir  + "/" + FILE_NAME, Toast.LENGTH_LONG).show()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (fos != null) {
                    try {
                        fos.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}