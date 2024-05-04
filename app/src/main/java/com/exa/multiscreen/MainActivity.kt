package com.exa.multiscreen

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//      USING THE CONCEPT OF GRADIENT COLOR

        //first is using xml but that has less functionality

        // SECOND WAY OF USING GRADIENT COLOR

        val gradientcolor1 = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                0XFFD98880.toInt(),
                0XFFF4D03F.toInt(),
                0XFF48C9B0.toInt(),
                0XFF2C3E50.toInt(),
                0XFFAF7AC5.toInt()
            )
        )

        val gradientcolor2 = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                0XFFD98880.toInt(),
                0XFFF4D03F.toInt(),
                0XFF48C9B0.toInt()
            )
        )
        //THIRD WAY OF USING GRADIENT COLOR
        val gradientDrawable = GradientDrawable()

        // Set the gradient colors
        gradientDrawable.colors = intArrayOf(
            ContextCompat.getColor(this, R.color.startColor),  // Start color
            ContextCompat.getColor(this, R.color.endColor)     // End color
        )

        // Set the gradient type (linear)
        gradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT

        // Set the gradient orientation (angle)
        gradientDrawable.orientation =
            GradientDrawable.Orientation.TL_BR  // Top-left to bottom-right

        // Set the shape (RECTANGLE is the default)
        gradientDrawable.shape = GradientDrawable.RECTANGLE

        val backtext1: TextView = findViewById(R.id.textf)
        backtext1.background = gradientDrawable

        val backtext2: TextView = findViewById(R.id.texts)
        backtext2.background = gradientDrawable

        val backtext3: TextView = findViewById(R.id.textt)
        backtext3.background = gradientDrawable

        val backtext4: TextView = findViewById(R.id.textfo)
        backtext4.background = gradientDrawable


        backtext1.setOnClickListener {
            val intent = Intent(this, NumberActivity::class.java)
            startActivity(intent)
        }
        backtext2.setOnClickListener {
            val intent = Intent(this, ColorsActivity::class.java)
            startActivity(intent)
        }
        backtext3.setOnClickListener {
            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }
        backtext4.setOnClickListener {
            val intent = Intent(this, PhrasesActivity::class.java)
            startActivity(intent)
        }
    }


}