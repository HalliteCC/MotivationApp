package com.example.motivationapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivationapp.infra.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.data.Mock
import com.example.motivationapp.infra.SecurityPreferences
import com.example.motivationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handleUserName()
        handleFilter(R.id.img_infinty)
        handleNextPhrase()

        //events
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imgInfinty.setOnClickListener(this)
        binding.imgSmile.setOnClickListener(this)
        binding.imgSun.setOnClickListener(this)
    }


    //Button New Phrase
    override fun onClick(view: View) {
        if (view.id == R.id.buttonNewPhrase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.img_infinty, R.id.img_smile, R.id.img_sun)) {
            handleFilter(view.id)
        }
    }


    //Next Phrase
    private fun handleNextPhrase (){
        binding.textMain.text = Mock().getPhrase(categoryId)
    }

    //Handle the User Name
    private fun handleUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        binding.textHello.text = "Olá, $name!"
    }


    //Changing Icon Colors
    private fun handleFilter(id: Int) {

        binding.imgInfinty.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        binding.imgSun.setColorFilter(ContextCompat.getColor(this, R.color.gray))
        binding.imgSmile.setColorFilter(ContextCompat.getColor(this, R.color.gray))


        when (id) {
            R.id.img_infinty -> {
                binding.imgInfinty.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.infinity

            }
            R.id.img_smile -> {
                binding.imgSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.smile
            }
            R.id.img_sun -> {
                binding.imgSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.sun
            }
        }
    }

}