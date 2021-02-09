package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import wallyson.lima.vivamovie.model.Movie

interface MovieService {
    @GET("movies")
    fun getAllMovies(): Call<List<Movie>>
}