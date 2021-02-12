package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import wallyson.lima.vivamovie.model.GetMoviesResponse

interface Api {
    @GET("discover/movie")
    fun getAllMovies(
        @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("search/movie?query=marvel")
    fun getAllMarvelMovies(
        @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

   @GET("discover/movie")
   fun getAllMoviesTopRated(
       @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
       @Query("sort_by") average : String = "vote_average.desc",
       @Query("page") page: Int = 10
   ): Call<GetMoviesResponse>
}