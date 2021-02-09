package wallyson.lima.vivamovie.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import wallyson.lima.vivamovie.model.Movie

@Dao
interface MovieDAO {
    @Query("SELECT title, popularity, posterPath, releaseDate, nameCompanie, nameGenre FROM Movie LIMIT 16;")
    fun getAllMovies(): LiveData<List<Movie>>

}