package com.exa.multiscreen

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class PhrasesActivity : AppCompatActivity() {

    var audio: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)


        val textarr = arrayOf(
            MyTextImg("Where are you doing", "Mintu wuksus", R.raw.phrase_where_are_you_going),
            MyTextImg("What is your name", "Tinna oyyasina", R.raw.phrase_what_is_your_name),
            MyTextImg("My name is", "Oyyasit", R.raw.phrase_my_name_is),
            MyTextImg("How are you felling", "Michaksus", R.raw.phrase_how_are_you_feeling),
            MyTextImg("I'm felling good", "Kuchi Achit", R.raw.phrase_im_feeling_good),
            MyTextImg("Are you coming", "Aanas'aa", R.raw.phrase_are_you_coming),
            MyTextImg("Yes I'm coming", "Haa'aanam", R.raw.phrase_yes_im_coming),
            MyTextImg("I'm coming", "Aanam", R.raw.phrase_im_coming)
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.background = gradientDrawable(this).gradientColor

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val customAdapter =
            MyTextImgAdapter(this, R.color.phrases_color, R.layout.img_textview, textarr)

        val listView = findViewById<ListView>(R.id.listview)

        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, view, position, _ ->
            val item: MyTextImg = textarr[position]
            audio = MediaPlayer.create(this@PhrasesActivity, item.get_Audio())
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