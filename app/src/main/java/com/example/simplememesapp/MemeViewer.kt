package com.example.simplememesapp

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_meme_viewer.*

class MemeViewer : AppCompatActivity() {

    private  val listUrl : MutableList<String> = ArrayList()
    private var previous : String  = "https://meme-api.herokuapp.com/gimme"
    private var currentImage: String? = null
    private var upVotes: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme_viewer)
        val type = intent.getStringExtra("EXTRA_TYPE")
        val url: String = intent.getStringExtra("EXTRA_URL").toString()
        tvCategory.text = type


        loadMeme(url)



        btnNext.setOnClickListener {
            loadMeme(url)
        }

        btnPrevious.setOnClickListener {

            if(listUrl.size > 1) {
                loadMeme(listUrl[listUrl.size - 2])
                Glide.with(this).load(listUrl[listUrl.size-2]).into(myZoomageView)
                listUrl.remove(listUrl[listUrl.size-2])
            }
            else {
                Toast.makeText(this, "Bruh Can you don't", Toast.LENGTH_SHORT).show()
            }


        }

        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Check this out $currentImage Contact for app t.me/Slayer39")
            val chooser = Intent.createChooser(intent, "Share it using")
            startActivity(chooser)
        }


    }

    private fun loadMeme(url: String) {

        // Instantiate the RequestQueue.


// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                upVotes = response.getString("ups").toString()
                val tvtext = "$upVotes Ups"
                tvUpvotes.text = tvtext
                currentImage = response.getString("url")
                previous = currentImage as String
                listUrl.add(previous)
                Glide.with(this).load(currentImage).listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(myZoomageView)


            },
            {

            })



// Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
    }
