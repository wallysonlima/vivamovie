package wallyson.lima.vivamovie.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import wallyson.lima.vivamovie.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie LIMIT 16;")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY title ASC LIMIT 16;")
    fun getAllMoviesOrderAsc(): LiveData<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompany, nameGenre FROM Movie Where nameCompany LIKE :nameCompanie LIMIT 16;")
    public fun getAllMoviesByCompanie(nameCompanie : String): LiveData<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY popularity DESC LIMIT 16;")
    public fun getAllBestMovies(): LiveData<List<Movie>>

    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie ORDER BY releaseDate DESC LIMIT 16;")
    public fun getAllNewMovies() : LiveData<List<Movie>>
}