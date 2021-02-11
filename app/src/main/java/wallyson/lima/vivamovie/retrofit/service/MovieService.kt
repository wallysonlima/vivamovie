package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import wallyson.lima.vivamovie.model.GetMoviesResponse

interface MovieService {
    @GET("movie/popular")
    fun getAllMovies(
        @Query("api_key") apiKey: String = "6df08486f63fa614bf2d234b05405c97",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

   @GET("/genre/movie/list")
   fun getAllMoviesByGenre(
       @Query("api_key") apiKey: String = "6df08486f63fa614bf2d234b05405c97",
       @Query("page") page: Int
   ): Call<GetMoviesResponse>
}