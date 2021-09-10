package com.example.loluserinfoapp

import android.graphics.BitmapFactory
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.io.InputStream

@BindingAdapter("imageUrl")
fun bindBitmapImage(imageView:ImageView, inputStream:InputStream?){
    val bitmap = BitmapFactory.decodeStream(inputStream)
    imageView.setImageBitmap(bitmap)
}

@BindingAdapter("setName")
fun setName(textView: TextView, name:String? ){
    if(name.isNullOrEmpty()){
        textView.visibility  = View.INVISIBLE
    }else{
        textView.visibility = View.VISIBLE
        val str = "소환사 이름은 : $name 입니다."
        val spannableString = SpannableString(str)
        val start = str.indexOf(name)
        val end = start+name.length
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF6200EE")), start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString
    }
}

@BindingAdapter("setLevel")
fun setLevel(textView: TextView, level:Int?){
    if(level==0){
        textView.visibility  = View.INVISIBLE
    }else{
        textView.visibility = View.VISIBLE
        val str = "소환사 레벨은 : $level 입니다."
        val spannableString = SpannableString(str)
        val start = str.indexOf(level.toString())
        val end = start+level.toString().length
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF6200EE")), start,end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString
    }
}

