package wallyson.lima.vivamovie.presenter

import android.content.Context
import wallyson.lima.vivamovie.factory_method.AppDatabase

class MoviePresenter {
    private lateinit var mView : MovieInterface
    private var ctx : Context
    private var db: AppDatabase? = null

    constructor(mView : MovieInterface?, ctx: Context) {
        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = AppDatabase.getDatabaseHelper(ctx)
    }
}