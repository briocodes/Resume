package com.briocodes.meetbrio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.progressindicator.LinearProgressIndicator
import java.util.*

class Profile : AppCompatActivity() {
    lateinit var javaIndicator: LinearProgressIndicator
    lateinit var kotlinIndicator: LinearProgressIndicator
    lateinit var xmlIndicator: LinearProgressIndicator
    lateinit var gitIndicator: LinearProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        javaIndicator = findViewById(R.id.java_indicator)
        kotlinIndicator = findViewById(R.id.kotlin_indicator)
        xmlIndicator = findViewById(R.id.xml_indicator)
        gitIndicator = findViewById(R.id.git_indicator)
        setProgress()

    }

    /**
     * Method sets the progress bars showing the level of knowledge for the various skill-sets indicated
     */
    private fun setProgress() {

        val taskJava: TimerTask
        val taskKotlin: TimerTask
        val taskXml: TimerTask
        val taskGit: TimerTask

        val javaTimer: Timer = Timer()
        taskJava = object : TimerTask() {
            var javaProgress = 0
            override fun run() {
                javaProgress += 1
                javaIndicator.setProgressCompat(javaProgress, true)
                if (javaProgress == 65) {
                    javaTimer.cancel()
                }
            }
        }
        javaTimer.schedule(taskJava, 1000, 100)
        val kotlinTimer: Timer = Timer()
        taskKotlin = object : TimerTask() {
            var kotlinProgress = 0
            override fun run() {
                kotlinProgress += 1
                kotlinIndicator.setProgressCompat(kotlinProgress, true)
                if (kotlinProgress == 50) {
                    kotlinTimer.cancel()
                }
            }
        }
        kotlinTimer.schedule(taskKotlin, 1000, 100)
        val gitTimer: Timer = Timer()
        taskGit = object : TimerTask() {
            var gitProgress = 0
            override fun run() {
                gitProgress += 1
                gitIndicator.setProgressCompat(gitProgress, true)
                if (gitProgress == 85) {
                    gitTimer.cancel()
                }
            }
        }
        gitTimer.schedule(taskGit, 1000, 100)
        val xmlTimer: Timer = Timer()
        taskXml = object : TimerTask() {
            var xmlProgress = 0
            override fun run() {
                xmlProgress += 1
                xmlIndicator.setProgressCompat(xmlProgress, true)
                if (xmlProgress == 75) {
                    xmlTimer.cancel()
                }
            }
        }
        xmlTimer.schedule(taskXml, 1000, 100)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.resume -> {
                startActivity(Intent(this,Resume::class.java))
                true
            }
            R.id.certs -> {
                startActivity(Intent(this,Certifications::class.java))
                true
            }
            R.id.projects -> {
                startActivity(Intent(this,Projects::class.java))
                true
            }
            R.id.services -> {
                startActivity(Intent(this,Services::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}