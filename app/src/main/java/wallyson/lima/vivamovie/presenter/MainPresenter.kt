package wallyson.lima.vivamovie.presenter

import android.content.Context
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.factory_method.AppDatabase

class MainPresenter {
    private lateinit var mView : MainInterface
    private var ctx : Context
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null

    constructor(mView : MainInterface?, ctx: Context) {

        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = AppDatabase.getDatabaseHelper(ctx)
        userDao = db?.userDao()
    }

    public fun login() : Boolean {
        val name : String = mView.getName()
        val password : String = mView.getPassword()

        if ( name.isNotEmpty() && password.isNotEmpty()) {
            val user = userDao?.getUser(name, password)

            return user?.getName().toString().isNotEmpty() && user?.getPassword().toString().isNotEmpty()
        }

        return false
    }
}