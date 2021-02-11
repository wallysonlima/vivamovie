package wallyson.lima.vivamovie.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import wallyson.lima.vivamovie.R

class UI_MainOptionsActivity : AppCompatActivity() {
    private lateinit var buttonListMovies: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_options)

        initiate()

        buttonListMovies.setOnClickListener {
            listMovies()
        }
    }

    fun initiate() {
        buttonListMovies = findViewById(R.id.buttonListMovies)
    }

    fun listMovies() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        startActivity(intent)
    }
}