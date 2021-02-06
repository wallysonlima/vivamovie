package wallyson.lima.vivamovie

import org.junit.Test

import org.junit.Assert.*
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.factory_method.DatabaseHelper
import kotlin.coroutines.coroutineContext

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private var db: DatabaseHelper? = null
    private var userDao: UserDao? = null

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}