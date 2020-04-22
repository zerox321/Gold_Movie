package com.gado.movieapp.binding

import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.gado.movieapp.R
import com.gado.network.EndPoint.BASE_POSTER_PATH
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@BindingAdapter("bindingPostUrl")
fun bindingPostUrl(imageView: ImageView, path: String?) {
    Glide.with(imageView.context)
        .load("$BASE_POSTER_PATH$path")
        .error(ContextCompat.getDrawable(imageView.context, R.mipmap.ic_launcher))
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .into(imageView)
}
@BindingAdapter("bindingCirclePostUrl")
fun bindingCirclePostUrl(imageView: ImageView, path: String?) {
    Glide.with(imageView.context)
        .load("$BASE_POSTER_PATH$path")
        .error(ContextCompat.getDrawable(imageView.context, R.mipmap.ic_launcher))
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .apply(RequestOptions().circleCrop())
        .into(imageView)
}

@BindingAdapter("loadYouTube")
fun loadYouTube(youTubePlayerView: YouTubePlayerView, key: String) {
    youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
        override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
            youTubePlayer.loadVideo(key, 0f)
            youTubePlayer.pause()
        }
    })
}








