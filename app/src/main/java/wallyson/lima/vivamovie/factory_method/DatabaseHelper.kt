package wallyson.lima.vivamovie.factory_method

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DatabaseHelper : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: DatabaseHelper? = null

        fun getDatabaseHelper(ctx : Context): DatabaseHelper? {
            if ( INSTANCE == null ) {
                synchronized(DatabaseHelper::class) {
                    INSTANCE = Room.databaseBuilder(ctx.applicationContext, DatabaseHelper::class.java, "vivamovie.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}