package wallyson.lima.vivamovie.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import wallyson.lima.vivamovie.model.Person

@Dao
interface PersonDAO {
    @Query("Select name, knowForDepartment, birthday, placeOfBirthday, biography, popularity FROM Person LIMIT 16;")
    fun getAllArtist(): LiveData<List<Person>>
}