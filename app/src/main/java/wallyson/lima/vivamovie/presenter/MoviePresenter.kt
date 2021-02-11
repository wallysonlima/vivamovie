package wallyson.lima.vivamovie.presenter

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import wallyson.lima.vivamovie.factory_method.AppDatabase
import wallyson.lima.vivamovie.model.Movie
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import wallyson.lima.vivamovie.retrofit.webclient.MovieWebClient

class MoviePresenter {
    private lateinit var mView : MovieInterface
    private lateinit var ctx : Context
    private var db: AppDatabase? = null
    private var movieDao: MovieDao? = null
    private val webclient: MovieWebClient = MovieWebClient()

    private val mediator = MediatorLiveData<Resource<List<Movie>?>>()

    constructor(mView : MovieInterface?, ctx: Context) {

        if (mView != null) {
            this.mView = mView
        }

        this.ctx = ctx
        db = AppDatabase.getDatabaseHelper(ctx)
        movieDao = db?.movieDao()
    }


    fun listAllMovies(): LiveData<Resource<List<Movie>?>> {
        val failWebApiLiveData = MutableLiveData<Resource<List<Movie>?>>()

        mediator.addSource(failWebApiLiveData) {failResource ->
            val actualResource = mediator.value
            val newResource: Resource<List<Movie>?> = if(actualResource != null) {
                Resource(data = actualResource.data, error = failResource.error)
            } else {
                failResource
            }

            mediator.value = newResource
        }

        findInApi(
            fail = { error ->
                failWebApiLiveData.value = Resource(data = null, error = error)
            })

        return mediator
    }

    private fun findInApi(
        fail: (error: String?) -> Unit
    ) {
        webclient.getAllMovies(
            succeed = { newMovies ->
              newMovies?.let {

              }
            }, fail = fail
        )
    }
}