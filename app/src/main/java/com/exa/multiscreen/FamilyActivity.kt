package com.exa.multiscreen

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class FamilyActivity : AppCompatActivity() {

    var audio: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)

        val textarr = arrayOf(
            MyTextImg("Father", "Apa", R.drawable.family_father, R.raw.family_father),
            MyTextImg("Mother", "Ata", R.drawable.family_mother, R.raw.family_mother),
            MyTextImg("Son", "Angsi", R.drawable.family_son, R.raw.family_son),
            MyTextImg("Daughter", "Tune", R.drawable.family_daughter, R.raw.family_daughter),
            MyTextImg(
                "Older Brother",
                "Taachi",
                R.drawable.family_older_brother,
                R.raw.family_older_brother
            ),
            MyTextImg(
                "Younger Brother",
                "Chalitti",
                R.drawable.family_younger_brother,
                R.raw.family_younger_brother
            ),
            MyTextImg(
                "Older Sister",
                "Tete",
                R.drawable.family_older_sister,
                R.raw.family_older_sister
            ),
            MyTextImg(
                "Younger Sister",
                "Kollete",
                R.drawable.family_younger_sister,
                R.raw.family_younger_sister
            ),
            MyTextImg(
                "Grand Father",
                "Ama",
                R.drawable.family_grandfather,
                R.raw.family_grandfather
            ),
            MyTextImg(
                "Grand Mother",
                "Apa",
                R.drawable.family_grandmother,
                R.raw.family_grandmother
            )
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.background = gradientDrawable(this).gradientColor

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val customAdapter =
            MyTextImgAdapter(this, R.color.family_color, R.layout.img_textview, textarr)

        val listView = findViewById<ListView>(R.id.listview)

        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, view, position, _ ->
            val item: MyTextImg = textarr[position]
            audio = MediaPlayer.create(this@FamilyActivity, item.get_Audio())
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