package com.exa.multiscreen

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar


class NumberActivity : AppCompatActivity() {

    var audio: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)

        val textarr = arrayOf(
            MyTextImg("One", "Lutti", R.drawable.number_one, R.raw.number_one),
            MyTextImg("Two", "Otiiko", R.drawable.number_two, R.raw.number_two),
            MyTextImg("Three", "Tolookasu", R.drawable.number_three, R.raw.number_three),
            MyTextImg("Four", "Oyyissa", R.drawable.number_four, R.raw.number_four),
            MyTextImg("Five", "Massoka", R.drawable.number_five, R.raw.number_five),
            MyTextImg("Six", "Temmokka", R.drawable.number_six, R.raw.number_six),
            MyTextImg("Seven", "Kenekau", R.drawable.number_seven, R.raw.number_seven),
            MyTextImg("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight),
            MyTextImg("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine),
            MyTextImg("Ten", "Na'accha", R.drawable.number_ten, R.raw.number_ten)
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.background = gradientDrawable(this).gradientColor

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val customAdapter =
            MyTextImgAdapter(this, R.color.numbers_color, R.layout.img_textview, textarr)

        val listView = findViewById<ListView>(R.id.listview)

        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, view, position, _ ->
            val item: MyTextImg = textarr[position]
            audio = MediaPlayer.create(this@NumberActivity, item.get_Audio())
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
