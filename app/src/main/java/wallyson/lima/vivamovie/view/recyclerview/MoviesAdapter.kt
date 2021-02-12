package wallyson.lima.vivamovie.view.recyclerview

import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.view.UI_MovieItemActivity

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

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MovieViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        var title : TextView = itemView.findViewById(R.id.textViewTitle)
        var popularity : Button = itemView.findViewById(R.id.buttonPopularity)
        var posterPath : ImageView = itemView.findViewById(R.id.imageViewBackground)
        var releaseDate : TextView = itemView.findViewById(R.id.textViewYear)

        fun bind(movie: Movie) {
            title.setText(movie.title)
            popularity.setText(movie.popularity)
            releaseDate.setText(movie.releaseDate)

            Picasso.with(context)
                .load(movie.posterPath)
                .centerCrop()
                .into(posterPath)

            posterPath.setOnClickListener {
                val intent = Intent(context, UI_MovieItemActivity::class.java)
                intent.putExtra("title", movie.title )
                intent.putExtra("posterPath", movie.posterPath)
                intent.putExtra("popularity", movie.popularity)
                intent.putExtra("date", movie.releaseDate)
                startActivity(context, intent, null)
            }
        }
    }
}
