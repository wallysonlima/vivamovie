package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import wallyson.lima.vivamovie.R

class UI_MovieItemActivity : AppCompatActivity() {
    private lateinit var buttonBack : Button
    private lateinit var title: TextView
    private lateinit var genre: TextView
    private lateinit var date : TextView
    private lateinit var sinopse : TextView
    private lateinit var posterPath : ImageView
    private lateinit var background : ImageView
    private lateinit var rating : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_item)

        initialize()

        buttonBack.setOnClickListener {
            finish()
        }

        title.setText(intent.getStringExtra("title").toString())
        //val posterPath = intent.getStringExtra("posterPath").toString()
        rating.setText(intent.getStringExtra("rating"))
        date.setText(intent.getStringExtra("date"))
        sinopse.setText(intent.getStringExtra("sinopse"))

        Glide.with(this)
            .load(intent.getStringExtra("posterPath"))
            .transform(CenterCrop())
            .into(posterPath)

        Glide.with(this)
            .load(intent.getStringExtra("posterPath"))
            .transform(CenterCrop())
            .into(background)
    }

    fun initialize() {
        buttonBack = findViewById(R.id.buttonBack)
        title = findViewById(R.id.textViewTitle)
        genre = findViewById(R.id.textViewGenre)
        date = findViewById(R.id.textViewDate)
        sinopse = findViewById(R.id.textViewSinopse)
        posterPath = findViewById(R.id.imageViewImage)
        background = findViewById(R.id.imageViewPoster)
        rating = findViewById(R.id.buttonRating3)
    }
}