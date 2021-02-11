package wallyson.lima.vivamovie.retrofit.service

import androidx.lifecycle.LiveData
import androidx.room.Query
import retrofit2.Call
import retrofit2.http.GET
import wallyson.lima.vivamovie.model.Movie

interface MovieService {
    @GET("movie")
    fun getAllMovies(): Call<List<Movie>>

    @GET("movie")
    fun getAllMoviesOrderAsc(): Call<List<Movie>>

    @GET("movie")
    public fun getAllMoviesByCompanie(nameCompanie : String): Call<List<Movie>>

    @GET("movie")
    public fun getAllBestMovies(): Call<List<Movie>>

    @GET("movie")
    public fun getAllNewMovies() : Call<List<Movie>>
}