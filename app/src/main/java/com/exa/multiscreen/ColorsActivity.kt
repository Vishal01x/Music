package com.exa.multiscreen

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class ColorsActivity : AppCompatActivity() {

    var audio: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)


        val textarr = arrayOf(
            MyTextImg("Red", "Wetetti", R.drawable.color_red, R.raw.color_red),
            MyTextImg(
                "Mustard Yellow",
                "Chiwiita",
                R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow
            ),
            MyTextImg(
                "Dusty Yellow",
                "Topissa",
                R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow
            ),
            MyTextImg("Green", "Chokokki", R.drawable.color_green, R.raw.color_green),
            MyTextImg("Brown", "Takaakki", R.drawable.color_brown, R.raw.color_brown),
            MyTextImg("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray),
            MyTextImg("Black", "Kululli", R.drawable.color_black, R.raw.color_black),
            MyTextImg("White", "Kelilli", R.drawable.color_white, R.raw.color_white)
        )


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.background = gradientDrawable(this).gradientColor

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val customAdapter =
            MyTextImgAdapter(this, R.color.colors_color, R.layout.img_textview, textarr)

        val listView = findViewById<ListView>(R.id.listview)

        listView.adapter = customAdapter


        listView.setOnItemClickListener { _, view, position, _ ->
            val item: MyTextImg = textarr[position]
            audio = MediaPlayer.create(this@ColorsActivity, item.get_Audio())
            audio?.start()

            audio?.setOnCompletionListener {
                releaseMediaPlayer()
            }
        }

    }

    fun releaseMediaPlayer() {
        if (audio != null) {
            audio!!.release() // we can also use ?. but here we 100% sure that it is not empty
            audio = null

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId

        if (itemId == android.R.id.home) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}