package com.example.numberguessinggame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberguessinggame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var score = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val randomNum = Random.nextInt(1, 100)
        binding.textViewScore.text= "Score: ${score}"

        binding.buttonGuess.setOnClickListener {
            //makeGuess()

            val guess = binding.editTextYourGuess.text.toString()
            val guessedNumber = guess.toInt()

            if(score!=0 && guessedNumber<100){
                if (randomNum > guessedNumber) {
                    binding.textViewResult.setText("Try a greater number!")
                    score -= 1
                    binding.textViewScore.text= "Score: ${score}"
                }
                else if (randomNum < guessedNumber) {
                    binding.textViewResult.setText("Try a smaller number!")
                    score -= 1
                    binding.textViewScore.text= "Score: ${score}"
                }
                else if (randomNum == guessedNumber) {
                    binding.textViewResult.setText("Congratulations, you guessed it right!")
                    binding.textViewScore.text= "Score: ${score}"
                }
            }
        }
    }

     @SuppressLint("SetTextI18n")
     fun makeGuess(){

     }
}