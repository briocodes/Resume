package com.briocodes.meetbrio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    lateinit var aboutBtn: Button
    lateinit var githubIcon: ImageView
    lateinit var twitterIcon: ImageView
    lateinit var linkedinIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()  //Displays a splash screen whenever the app is launched
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        aboutBtn = findViewById(R.id.about_btn)
        githubIcon = findViewById(R.id.github_icon)
        twitterIcon = findViewById(R.id.twitter_icon)
        linkedinIcon = findViewById(R.id.linkedin_icon)

        aboutBtn.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        })

        githubIcon.setOnClickListener(View.OnClickListener { view ->
            val githubIntent = Intent(android.content.Intent.ACTION_VIEW)
            githubIntent.data = Uri.parse("https://github.com/briocodes")
            startActivity(githubIntent)
        })
        twitterIcon.setOnClickListener(View.OnClickListener { v ->
            val twitterIntent = Intent(android.content.Intent.ACTION_VIEW)
            twitterIntent.data = Uri.parse("https://twitter.com/briocodes")
            startActivity(twitterIntent)
        })
        linkedinIcon.setOnClickListener(View.OnClickListener { v ->
            val linkedinIntent = Intent(android.content.Intent.ACTION_VIEW)
            linkedinIntent.data = Uri.parse("https://ng.linkedin.com/in/brightokwu")
            startActivity(linkedinIntent)
        })
    }
}