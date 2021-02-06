package wallyson.lima.vivamovie.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import wallyson.lima.vivamovie.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User)

    @Query("SELECT name FROM User WHERE name = :name LIMIT 1;")
    fun getUser(name :String): String

    @Query("SELECT * FROM User WHERE name LIKE :name AND password LIKE :password LIMIT 1;")
    fun getUser(name :String, password :String): User
}