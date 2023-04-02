package com.example.seconddemoproject

import android.R
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.seconddemoproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.websiteBt.setOnClickListener {
            try {
                val url = binding.websiteEt.text.toString()
                val uri: Uri = Uri.parse(url)
                val intent: Intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
            }


        }
        binding.locationBt.setOnClickListener {

//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            }
            try {
                val location = binding.locationEt.text.toString()
                val addressUri: Uri = Uri.parse(location)
                val intent: Intent = Intent(Intent.ACTION_VIEW,addressUri)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
            }
        }

        binding.shareBt.setOnClickListener {
            val msg = binding.shareEt.text.toString()
            val mime = "text/plain"
            ShareCompat.IntentBuilder.from(this).setType(mime).setChooserTitle("share Text").setText(msg).startChooser()
        }
    }
}