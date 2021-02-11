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
import wallyson.lima.vivamovie.retrofit.AppRetrofit
import wallyson.lima.vivamovie.retrofit.service.MovieService

class MoviePresenter {
    private lateinit var mView : MovieInterface
    private var ctx : Context
    private var db: AppDatabase? = null
    private val BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=6df08486f63fa614bf2d234b05405c97"

    constructor(mView : MovieInterface?, ctx: Context) {
        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = AppDatabase.getDatabaseHelper(ctx)
    }

    fun listAllMovies() {
        val retrofitClient = AppRetrofit.getRetrofitInstance(BASE_URL)
        val movieService = retrofitClient.create(MovieService::class.java)
        val callback = movieService.getAllMovies()

        callback.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                error()
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                response.body()?.forEach {
                    TODO("FAZER DEPOIS")
                }
            }
        })
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