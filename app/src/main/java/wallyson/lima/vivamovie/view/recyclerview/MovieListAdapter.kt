package wallyson.lima.vivamovie.view.recyclerview

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.model.Movie


class MovieListAdapter (
    private val context: Context,
    private val movies: MutableList<Movie> = mutableListOf(),
    var clickItem: (movie: Movie) -> Unit = {}
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieListAdapter.ViewHolder {
        val createView = LayoutInflater.from(context)
            .inflate(
                R.layout.movie_item,
                parent, false
            )

        return ViewHolder(createView)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        var movie2 : Movie

        holder.vincula(movie)
    }

    fun update(movies: List<Movie>) {
        notifyItemRangeRemoved(0, this.movies.size)
        this.movies.clear()
        this.movies.addAll(movies)
        notifyItemRangeInserted(0, this.movies.size)
    }

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        private lateinit var movie: Movie

        init {
            itemView.setOnClickListener {
                if (::movie.isInitialized) {
                    clickItem(movie)
                }
            }
        }

        fun vincula(movie: Movie) {
            this.movie = movie
            Picasso.with(context).load(movie.getPosterPath()).into(itemView.imageViewBackground1)
            itemView.textViewTitle1.text = movie.getTitle()
            itemView.textViewYear1.text = movie.getReleaseDate()
            itemView.buttonPopularity1.text = movie.getPopularity().toString()
        }
    }
}