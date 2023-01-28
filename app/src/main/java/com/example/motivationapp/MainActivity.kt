package com.example.motivationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handleUserName()


        //events
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonNewPhrase){
            var s = ""
        }
    }

    private fun handleUserName (){

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        binding.textHello.text = "Olá, $name!"
    }
}