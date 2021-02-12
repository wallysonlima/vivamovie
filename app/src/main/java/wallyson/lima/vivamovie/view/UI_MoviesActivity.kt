package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_erro.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.GetMoviesResponse
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.retrofit.MovieRepository
import wallyson.lima.vivamovie.view.recyclerview.MoviesAdapter


class UI_MoviesActivity : AppCompatActivity() {
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        if (Build.VERSION.SDK_INT > 9) {
            val policy =
                StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

          type = intent.getStringExtra("type").toString()

          var recycler :RecyclerView = findViewById(R.id.recycler)
          moviesAdapter = MoviesAdapter(this, mutableListOf())

        val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.layoutManager = layout
        recycler.adapter = moviesAdapter
        moviesAdapter.notifyDataSetChanged()
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()

        when(type) {
            "movies" ->
                MovieRepository.getAllMovies(
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )

            "top" ->
                MovieRepository.getAllTopMovies(
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )

            "marvel" ->
                MovieRepository.getAllMarvelMovies(
                    onSuccess = ::onMoviesFetched,
                    onError = ::onError
                )
            }
    }

    private fun onMoviesFetched(movies: List<Movie>) {
        Log.d("MainActivity", "Movies: $movies")
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
