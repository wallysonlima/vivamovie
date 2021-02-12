package wallyson.lima.vivamovie.view.recyclerview

import android.content.Context
import android.content.Intent
import android.os.Build.*

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.view.UI_MovieItemActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MoviesAdapter (
    private val context: Context,
    private var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    @RequiresApi(VERSION_CODES.O)
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        var title : TextView = itemView.findViewById(R.id.textViewTitle)
        var rating : Button = itemView.findViewById(R.id.buttonRating3)
        var posterPath : ImageView = itemView.findViewById(R.id.imageViewBackground)
        var releaseDate : TextView = itemView.findViewById(R.id.textViewYear)

        var formatEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        var formatSaida = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
        lateinit var dataOriginal : Date
        lateinit var novoFormato : String


        @RequiresApi(VERSION_CODES.O)
        fun bind(movie: Movie) {
            title.setText(movie.title)
            rating.setText(movie.rating.toString())
//            var date = LocalDate.parse(movie.releaseDate, format)

            try {
                dataOriginal = formatEntrada.parse(movie.releaseDate)
                novoFormato = formatSaida.format(dataOriginal)
                releaseDate.setText(novoFormato)
            } catch (e : ParseException) {
                e.printStackTrace()
            }

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(posterPath)

            posterPath.setOnClickListener {
                val intent = Intent(context, UI_MovieItemActivity::class.java)
                intent.putExtra("title", movie.title )
                intent.putExtra("posterPath","https://image.tmdb.org/t/p/w342${movie.posterPath}")
                intent.putExtra("rating", movie.rating.toString())
                intent.putExtra("date", novoFormato)
                intent.putExtra("sinopse", movie.overview)
                startActivity(context, intent, null)
            }
        }
    }
}
