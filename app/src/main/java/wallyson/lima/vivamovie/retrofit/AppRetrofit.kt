package wallyson.lima.vivamovie.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wallyson.lima.vivamovie.retrofit.service.MovieService

private const val BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=6df08486f63fa614bf2d234b05405c97"

class AppRetrofit {
    companion object {
        private val client by lazy {
            val interceptador = HttpLoggingInterceptor()
            interceptador.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptador)
                .build()
        }

        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}