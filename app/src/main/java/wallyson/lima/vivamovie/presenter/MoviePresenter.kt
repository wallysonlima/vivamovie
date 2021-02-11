package wallyson.lima.vivamovie.presenter

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import wallyson.lima.vivamovie.factory_method.AppDatabase
import wallyson.lima.vivamovie.model.Movie
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.retrofit.AppRetrofit
import wallyson.lima.vivamovie.retrofit.service.MovieService
import wallyson.lima.vivamovie.retrofit.webclient.MovieWebClient

class MoviePresenter {
    private lateinit var mView : MovieInterface
    private lateinit var ctx : Context
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