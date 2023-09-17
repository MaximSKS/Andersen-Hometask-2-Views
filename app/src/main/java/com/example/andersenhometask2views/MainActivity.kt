package com.example.andersenhometask2views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.andersenhometask2views.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val toastMessage = "Error, please enter URL correctly"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLoadImage.setOnClickListener {

            val imageUrl = binding.editTextUrl.text.toString()

            if (isValidUrl(imageUrl)) {
                loadImage(imageUrl)
            } else {
                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun isValidUrl(url: String): Boolean {
        return URLUtil.isValidUrl(url)
    }

    private fun loadImage(imageURL: String) {

        Glide.with(this)
            .load(imageURL)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)


    }

}

