package com.example.mainproject.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mainproject.App
import java.text.SimpleDateFormat
import java.util.*

object DataBindingComponents {

    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(imageView: ImageView, url: String) {
        Glide.with(App.context!!).load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("setDate")
    fun setDate(textView: TextView, date: String) {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.US)
        val formattedDate = formatter.format(parser.parse(date))

        textView.text = formattedDate
    }
}