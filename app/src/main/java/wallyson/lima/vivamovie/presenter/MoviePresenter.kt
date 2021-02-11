package wallyson.lima.vivamovie.presenter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_erro.view.*
import wallyson.lima.vivamovie.factory_method.AppDatabase
import wallyson.lima.vivamovie.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.retrofit.MovieRepository
import wallyson.lima.vivamovie.retrofit.service.MovieService

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

    fun getAllMovies() {

    }

    fun error() {
        val mDialogView = LayoutInflater.from(ctx).inflate(R.layout.activity_erro, null)

        val mBuilder = AlertDialog.Builder(ctx)
            .setView(mDialogView)
            .setTitle("Error")

        val mAlertDialog = mBuilder.show()

        mDialogView.buttonError.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}