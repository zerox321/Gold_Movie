package com.gado.movieapp.util

import android.animation.Animator
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

fun hideBottomNavigationView(view: BottomNavigationView) {
    view.animate().translationY(view.height.toFloat())
        .setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.GONE
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
}

fun showBottomNavigationView(view: BottomNavigationView) {
    view.animate().translationY(0f)
        .setListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                view.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })


}