package com.example.jobsheet4

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity () {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener(){
        rockImageButton.setOnClickListener { StartGame("ROCK")}
        scissorsImageButton.setOnClickListener { StartGame("Scissors")}
        paperImageButton.setOnClickListener { StartGame("PAPER")}

    }

    private fun StartGame(option:String){
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDrwa(option,computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option,computerOption) -> resultImageView.setImageResource(R.drawable.win)

        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListener()
    }

}