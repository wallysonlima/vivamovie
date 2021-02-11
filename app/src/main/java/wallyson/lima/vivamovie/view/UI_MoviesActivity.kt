package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.MovieInterface
import wallyson.lima.vivamovie.presenter.MoviePresenter

class UI_MoviesActivity : AppCompatActivity(), MovieInterface {
    private lateinit var mPresenter : MoviePresenter
    private val type = intent.getStringExtra("type")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initialize()
    }

    fun initialize() {
        mPresenter = MoviePresenter(this, applicationContext )
    }

    override fun getAllMovies() {
        mPresenter.getAllMovies()
    }
}
