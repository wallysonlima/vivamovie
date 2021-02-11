package wallyson.lima.vivamovie.presenter

import android.content.Context
import wallyson.lima.vivamovie.factory_method.AppDatabase
import wallyson.lima.vivamovie.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.retrofit.AppRetrofit
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

    fun listAllMovies() {
        val retrofitClient = AppRetrofit.getRetrofitInstance()
        val movieService = retrofitClient.create(MovieService::class.java)
        val callback = movieService.getAllMovies()

        callback.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                TODO("FAZER DEPOIS")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                response.body()?.forEach {
                    TODO("FAZER DEPOIS")
                }
            }
        })
    }
}