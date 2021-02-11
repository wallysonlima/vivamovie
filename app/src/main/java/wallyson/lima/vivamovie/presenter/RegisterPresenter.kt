package wallyson.lima.vivamovie.presenter

import android.content.Context
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.factory_method.AppDatabase
import wallyson.lima.vivamovie.model.User

class RegisterPresenter {
    private lateinit var mView : RegisterInterface
    private var ctx : Context
    private var db: AppDatabase? = null
    private var userDao: UserDao? = null

    constructor(mView : RegisterInterface?, ctx: Context) {

        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = AppDatabase.getDatabaseHelper(ctx)
        userDao = db?.userDao()
    }

    public fun toRegister() : Boolean {
        val name : String = mView.getName()
        val password : String = mView.getPassword()

        if ( name.isNotEmpty() && password.isNotEmpty() && userDao?.getUser(name).isNullOrEmpty() ) {
            userDao?.insertUser( User(name, password) )
            return true
        }

        return false
    }
}