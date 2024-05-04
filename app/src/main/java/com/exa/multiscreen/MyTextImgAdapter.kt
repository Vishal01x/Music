package com.exa.multiscreen

import android.content.Context
import android.media.MediaPlayer
import android.provider.MediaStore.Audio
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MyTextImgAdapter(
    context: Context,
    color: Int,
    private val resource: Int,
    customtext: Array<MyTextImg>
) :
    ArrayAdapter<MyTextImg>(context, resource, customtext) {
    val back_color: Int = color

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listitemview = convertView
        if (listitemview == null) {
            listitemview = LayoutInflater.from(context).inflate(resource, parent, false)
        }

        val item: MyTextImg? = getItem(position)

        val text1: TextView = listitemview!!.findViewById(R.id.english_text)
        text1.text = item?.get_English()

        val text2: TextView = listitemview.findViewById(R.id.miwok_text)
        text2.text = item?.get_Miwok()

        val img: ImageView = listitemview.findViewById(R.id.img)

        if ((item != null) && item.hasImage()) {
            item.get_Image()?.let { img.setImageResource(it) }
            img.visibility = View.VISIBLE
        } else {
            img.visibility = View.GONE
        }

        /* INSTEAD OF SETTING ITEMCLICK EVENT IF YOU USE BUTTON THEN SUCH CODE IS REQUIRED

        val audio:Button = listitemview.findViewById(R.id.audio_btn)

        audio.setOnClickListener {
        val media: MediaPlayer? = item?.let { it1 ->
        MediaPlayer.create(context,
        it1.get_Audio())
        }
        if (media != null) {
        media.start()
        }
        }*/


       /* FOR SETTING DIFFERENT BACK COLOR FOR EACH ACTIVITY
        IF DIRECT COLOR IS SET THEN IT FIX FIRST ACTIVITY COLOR FOR ALL DUE TO CONSTANT VAL,
        THAT'S WHY A NEW LAYOUT_COLOR IS CREATED WHICH SET COLOR FOR THIS ACTIVITY
        */

        val text_layout: View = listitemview.findViewById(R.id.text_layout)
        val layout_color = ContextCompat.getColor(context, back_color)
        text_layout.setBackgroundColor(layout_color)

        return listitemview
    }
}