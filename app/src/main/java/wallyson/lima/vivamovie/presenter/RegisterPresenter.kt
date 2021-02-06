package wallyson.lima.vivamovie.presenter

import android.content.Context
import android.os.AsyncTask
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.factory_method.DatabaseHelper
import wallyson.lima.vivamovie.model.User

class RegisterPresenter {
    private lateinit var mView : RegisterInterface
    private lateinit var ctx : Context
    private var db: DatabaseHelper? = null
    private var userDao: UserDao? = null

    constructor(mView : RegisterInterface?, ctx: Context) {

        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = DatabaseHelper.getDatabaseHelper(ctx)
        userDao = db?.userDao()
    }

    public fun toRegister() : Boolean {
        val name : String = mView.getName()
        val password : String = mView.getPassword()

        if ( name.isNotEmpty() && password.isNotEmpty() ) {
            AsyncTask.execute{ userDao?.insertUser( User(name, password) ) }
            return true
        }

        return false
    }
}