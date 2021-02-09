package wallyson.lima.vivamovie.factory_method

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getDatabaseHelper(ctx : Context): AppDatabase? {
            if ( INSTANCE == null ) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java, "vivamovie.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}