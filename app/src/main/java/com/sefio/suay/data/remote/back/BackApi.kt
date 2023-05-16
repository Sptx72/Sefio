package com.sefio.suay.data.remote.back

import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.inject.Inject
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class BackApi @Inject constructor() : BasicApi{
    val okHttpClient = OkHttpClient.Builder()
        .apply {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                    println(chain)
                }

                override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                    println(chain)
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            val sslSocketFactory = sslContext.socketFactory
            sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            hostnameVerifier { _, _ -> true }
            addInterceptor(GenericInterceptor())
        }
        .build()

    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://d4e8-95-62-102-50.ngrok-free.app")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(okHttpClient)
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

    private class GenericInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val url: HttpUrl = request.url
            val newUrl = url.toString().replace("%2F", "/")

            val newHttpUrl = newUrl.toHttpUrl()

            val newRequest: Request = newHttpUrl.let {
                request.newBuilder()
                    .url(it)
                    .build()
            }

            return chain.proceed(newRequest)
        }

    }
}