package wallyson.lima.vivamovie.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wallyson.lima.vivamovie.retrofit.service.MovieService



class AppRetrofit {
    companion object {
        private val client by lazy {
            val interceptador = HttpLoggingInterceptor()
            interceptador.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptador)
                .build()
        }

        fun getRetrofitInstance(baseUrl: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}