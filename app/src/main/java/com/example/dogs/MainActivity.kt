package com.example.dogs

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDogImage()
    }

    private fun loadDogImage() {

        val thread = Thread {
            try {
                val url = URL(Constants.BASE_URL)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.connect()
                val string = connection.inputStream.bufferedReader().readText()

                Log.d("MainActivity", "${string}")

            } catch (e: Exception) {
                Log.d("MainActivity", "e: ${e}")
            }
        }.start()

    }
}