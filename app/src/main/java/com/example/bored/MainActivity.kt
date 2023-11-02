package com.example.bored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.bored.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                val response = try {
                    RetrofitInstance.api.getRandomActivity()
                }
                catch (e: IOException) {
                    Log.e(TAG,"IOException, check internet connection")
                    return@launchWhenCreated
                }
                catch (e: HttpException) {
                    Log.e(TAG,"HttpException, unexpected response")
                    return@launchWhenCreated
                }
                if (response.isSuccessful && response.body() != null)
                    binding.textView.text = response.body()!!.activity
                else Log.e(TAG,"response not successful")
            }
        }
    }
}