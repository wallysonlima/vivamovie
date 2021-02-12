package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_erro.view.*
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.retrofit.MovieRepository
import wallyson.lima.vivamovie.view.recyclerview.MovieListAdapter

class UI_MoviesActivity : AppCompatActivity() {
    private lateinit var movies: RecyclerView
    private lateinit var moviesAdapter: MovieListAdapter
    private lateinit var type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        type = intent.getStringExtra("type").toString()

        movies = findViewById(R.id.movies)
        movies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        moviesAdapter = MovieListAdapter(this, listOf())
        movies.adapter = moviesAdapter

        when(type) {
            "movies" ->
                MovieRepository.getAllMovies(
                    onSuccess = ::onMovieFetch,
                    onError = ::onError
                )

            "genre" ->
                MovieRepository.getAllGenreMovies(
                    onSuccess = ::onMovieFetch,
                    onError = ::onError
                )

            "company" ->
                MovieRepository.getAllMarvelMovies(
                    onSuccess = ::onMovieFetch,
                    onError = ::onError
                )
        }
    }

    private fun onMovieFetch(movies: List<Movie>) {
        moviesAdapter.update(movies)
    }

    private fun onError() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_erro, null)

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mDialogView.buttonError.setOnClickListener {
                mAlertDialog.dismiss()
        }
    }
}
