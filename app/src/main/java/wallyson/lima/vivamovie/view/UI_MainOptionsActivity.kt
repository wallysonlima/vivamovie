package wallyson.lima.vivamovie.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import wallyson.lima.vivamovie.R


class UI_MainOptionsActivity : AppCompatActivity() {
    private lateinit var buttonListMovies: Button
    private lateinit var buttonGenre: Button
    private lateinit var buttonCompany: Button
    private lateinit var buttonContact: Button
    private lateinit var buttonLocalization: Button
    private lateinit var buttonAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_options)

        if (Build.VERSION.SDK_INT > 9) {
            val policy =
                StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        initiate()

        buttonListMovies.setOnClickListener {
            listMovies()
        }

        buttonGenre.setOnClickListener {
            listGenre()
        }

        buttonCompany.setOnClickListener {
            listCompanies()
        }

        buttonContact.setOnClickListener {
            contact()
        }

        buttonLocalization.setOnClickListener {
            localization()
        }

        buttonAbout.setOnClickListener {
            about()
        }
    }

    fun initiate() {
        buttonListMovies = findViewById(R.id.buttonListMovies)
        buttonGenre = findViewById(R.id.buttonGenre)
        buttonCompany = findViewById(R.id.buttonCompany)
        buttonContact = findViewById(R.id.buttonContact)
        buttonLocalization = findViewById(R.id.buttonLocalization)
        buttonAbout = findViewById(R.id.buttonAbout)
    }

    fun listMovies() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        intent.putExtra("type", "movies")
        startActivity(intent)
    }

    private fun listGenre() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        intent.putExtra("type", "top")
        startActivity(intent)
    }

    private fun listCompanies() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        intent.putExtra("type", "marvel" )
        startActivity(intent)
    }

    private fun contact() {
        val intent = Intent(this, UI_ContactActivity::class.java)
        startActivity(intent)
    }

    private fun localization() {
        val intent = Intent(this, UI_MapsActivity::class.java)
        startActivity(intent)
    }

    private fun about() {
        val intent = Intent(this, UI_AboutActivity::class.java)
        startActivity(intent)
    }
}