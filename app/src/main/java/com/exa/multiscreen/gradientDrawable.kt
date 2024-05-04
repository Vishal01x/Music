package com.exa.multiscreen

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat

class gradientDrawable(context: Context) {

    val gradientColor = GradientDrawable()

    init {
        gradientColor.colors = intArrayOf(
            ContextCompat.getColor(context, R.color.startColor),
            ContextCompat.getColor(context, R.color.endColor)
        )
        gradientColor.gradientType = GradientDrawable.LINEAR_GRADIENT
        gradientColor.orientation = GradientDrawable.Orientation.TL_BR

    }
}