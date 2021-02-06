package wallyson.lima.vivamovie.presenter

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import wallyson.lima.vivamovie.dao.UserDao
import wallyson.lima.vivamovie.factory_method.DatabaseHelper

class MainPresenter {
    private lateinit var mView : MainInterface
    private lateinit var ctx : Context
    private var db: DatabaseHelper? = null
    private var userDao: UserDao? = null

    constructor(mView : MainInterface?, ctx: Context) {

        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = DatabaseHelper.getDatabaseHelper(ctx)
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