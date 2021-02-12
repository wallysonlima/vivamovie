package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_erro.view.*
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.retrofit.MovieRepository
import wallyson.lima.vivamovie.view.recyclerview.MoviesAdapter


class UI_MoviesActivity : AppCompatActivity() {
    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private lateinit var type: String
    private var popularMoviesPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        if (Build.VERSION.SDK_INT > 9) {
            val policy =
                StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        type = intent.getStringExtra("type").toString()

        popularMovies = findViewById(R.id.recycler)

        popularMoviesLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        popularMovies.layoutManager = popularMoviesLayoutMgr
        popularMoviesAdapter = MoviesAdapter(this, mutableListOf())
        popularMovies.adapter = popularMoviesAdapter

        when(type) {
            "movies" ->
                MovieRepository.getAllMovies(
                    popularMoviesPage,
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )

            "top" ->
                MovieRepository.getAllTopMovies(
                    popularMoviesPage,
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )

            "marvel" ->
                MovieRepository.getAllMarvelMovies(
                    popularMoviesPage,
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )
            }
    }

    private fun onMoviesFetched(movies: List<Movie>) {
       popularMoviesAdapter.updateMovies(movies)
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
