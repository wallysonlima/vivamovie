package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import wallyson.lima.vivamovie.R

class UI_MovieItemActivity : AppCompatActivity() {
    private lateinit var buttonBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_item)

        initialize()

        buttonBack.setOnClickListener {
            finish()
        }
    }

    fun initialize() {
        buttonBack = findViewById(R.id.buttonBack)
    }
}