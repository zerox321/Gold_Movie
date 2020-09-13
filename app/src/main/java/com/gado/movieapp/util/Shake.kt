package com.gado.movieapp.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.gado.movieapp.R


fun shake(view: View) {
    val shake: Animation = AnimationUtils.loadAnimation(view.context, R.anim.shake)
    view.startAnimation(shake)
}
