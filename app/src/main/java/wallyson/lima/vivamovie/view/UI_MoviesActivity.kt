package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.presenter.MainPresenter
import wallyson.lima.vivamovie.presenter.MovieInterface
import wallyson.lima.vivamovie.presenter.MoviePresenter
import wallyson.lima.vivamovie.view.recyclerview.MovieListAdapter

class UI_MoviesActivity : AppCompatActivity(), MovieInterface {
    private lateinit var mPresenter : MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initialize()
    }

    fun initialize() {
        mPresenter = MoviePresenter(this, applicationContext )
    }

    override fun getAllMovies() {
        mPresenter.listAllMovies()
    }
}