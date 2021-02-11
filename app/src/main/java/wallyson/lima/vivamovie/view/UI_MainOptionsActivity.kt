package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.quantity.view.*
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

    fun listMovies() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.quantity, null)

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(getString(R.string.selectoptions))

        val mAlertDialog = mBuilder.show()

        mDialogView.buttonSelect.setOnClickListener {
            val number = mDialogView.editTextNumber.text.toString()
            mAlertDialog.dismiss()

            if (Integer.parseInt(number) in 4..12) {
                val intent = Intent(this, UI_MoviesActivity::class.java)
                intent.putExtra("type", "movies")
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.tryagain), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun listGenre() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        intent.putExtra("type", "genre")
        startActivity(intent)
    }

    private fun listCompanies() {
        val intent = Intent(this, UI_MoviesActivity::class.java)
        intent.putExtra("type", "company" )
        startActivity(intent)
    }

    private fun contact() {
        val intent = Intent(this, UI_ContactActivity::class.java)
        startActivity(intent)
    }

    private fun localization() {
        val intent = Intent(this, UI_LocalizationActivity::class.java)
        startActivity(intent)
    }

    private fun about() {
        val intent = Intent(this, UI_AboutActivity::class.java)
        startActivity(intent)
    }

    fun initiate() {
        buttonListMovies = findViewById(R.id.buttonListMovies)
        buttonGenre = findViewById(R.id.buttonGenre)
        buttonCompany = findViewById(R.id.buttonCompany)
        buttonContact = findViewById(R.id.buttonContact)
        buttonLocalization = findViewById(R.id.buttonLocalization)
        buttonAbout = findViewById(R.id.buttonAbout)
    }
}