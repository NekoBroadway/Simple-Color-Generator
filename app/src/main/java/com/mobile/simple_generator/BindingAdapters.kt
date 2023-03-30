package com.mobile.simple_generator

import android.graphics.Color
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import com.mobile.simple_generator.models.Card

@BindingAdapter("cardText")
fun bindCardText(textView: TextView, text: String) {
    Log.i("bindCartText", "$text")
//    textView.text = text
}

@BindingAdapter("cardBackground")
fun bindBackgroundColor(constraintLayout: ConstraintLayout, color: String) {
    Log.i("bindBackgroundColor", "$color")
//    constraintLayout.setBackgroundColor(Color.parseColor(color))
}