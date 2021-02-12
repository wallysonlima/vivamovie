package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import wallyson.lima.vivamovie.model.GetMoviesResponse

interface MovieService {
    @GET("discover/movie")
    fun getAllMovies(
        @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("3/discover/movie")
    fun getAllMarvelMovies(
        @Query("query") marvel : String = "marvel",
        @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

   @GET("3/discover/movie/top_rated")
   fun getAllMoviesTopRated(
       @Query("api_key") apiKey : String = "6df08486f63fa614bf2d234b05405c97",
       @Query("page") page: Int
   ): Call<GetMoviesResponse>
}