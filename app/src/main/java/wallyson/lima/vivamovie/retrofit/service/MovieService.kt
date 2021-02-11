package wallyson.lima.vivamovie.retrofit.service

import androidx.lifecycle.LiveData
import androidx.room.Query
import retrofit2.Call
import retrofit2.http.GET
import wallyson.lima.vivamovie.model.Movie

interface MovieService {
    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie LIMIT 16;")
    fun getAllMovies(): Call<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY title ASC LIMIT 16;")
    fun getAllMoviesOrderAsc(): Call<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie Where nameCompanie LIKE :nameCompanie LIMIT 16;")
    public fun getAllMoviesByCompanie(nameCompanie : String): Call<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY popularity DESC LIMIT 16;")
    public fun getAllBestMovies(): Call<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY releaseDate DESC LIMIT 16;")
    public fun getAllNewMovies() : Call<List<Movie>>
}