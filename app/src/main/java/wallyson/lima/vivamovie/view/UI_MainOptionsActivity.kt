package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.view.*
import kotlinx.android.synthetic.main.quantity.view.*
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
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.tryagain), Toast.LENGTH_SHORT).show()
            }
        }
    }
}