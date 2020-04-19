package com.gado.network

import okhttp3.Interceptor
import okhttp3.Response


class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        // add TheMovieDB api automatically every requests.
        val url = originalUrl.newBuilder()
            .addQueryParameter("api_key", "33d4256907607c7062f0f08b1b125bfd")
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
