package com.example.simplememesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAllMemes.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme")
                it.putExtra("EXTRA_TYPE", "AllMemes")
                startActivity(it)
            }
        }

        btnMe_irl.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme/me_irl")
                it.putExtra("EXTRA_TYPE", "Me_irl")
                startActivity(it)
            }
        }

        btnDank.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme/dankmemes")
                it.putExtra("EXTRA_TYPE", "Dank")
                startActivity(it)
            }
        }

        btnProgrammer.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme/ProgrammerHumor")
                it.putExtra("EXTRA_TYPE", "Programmer")
                startActivity(it)
            }
        }

        btnDoge.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme/dogelore")
                it.putExtra("EXTRA_TYPE", "Doge")
                startActivity(it)
            }
        }

        btnWholesome.setOnClickListener {

            Intent(this, MemeViewer::class.java).also {
                it.putExtra("EXTRA_URL", "https://meme-api.herokuapp.com/gimme/wholesomememes")
                it.putExtra("EXTRA_TYPE", "Wholesome")
                startActivity(it)
            }
        }

    }
}