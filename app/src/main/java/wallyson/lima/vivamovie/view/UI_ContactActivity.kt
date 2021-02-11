package wallyson.lima.vivamovie.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import wallyson.lima.vivamovie.R

class UI_ContactActivity : AppCompatActivity() {
    private lateinit var buttonClean: Button
    private lateinit var buttonSend: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        initialize()

        buttonClean.setOnClickListener {
            clean()
        }

        buttonSend.setOnClickListener {
            if ( editTextName.text.isNotEmpty() && editTextPhone.text.isNotEmpty() && editTextEmail.text.isNotEmpty()
                && editTextMessage.text.isNotEmpty() ) {
                sendEmail()
            } else {
                Toast.makeText(this, getString(R.string.fill), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun initialize() {
        buttonClean = findViewById(R.id.buttonClean)
        buttonSend = findViewById(R.id.buttonSend)
        editTextName = findViewById(R.id.editTextName)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextMessage = findViewById(R.id.editTextMessage)
    }

    fun clean() {
        editTextName.setText("")
        editTextPhone.setText("")
        editTextEmail.setText("")
        editTextMessage.setText("")
    }

    fun sendEmail() {
//        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
//            val data = Uri.parse("mailto:" + editTextEmail.text.toString() )
//        }

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"

        emailIntent.putExtra(Intent.EXTRA_EMAIL, editTextEmail.text.toString())
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, editTextName.text.toString() + " -- " + editTextPhone.text.toString())
        emailIntent.putExtra(Intent.EXTRA_TEXT, editTextMessage.text.toString())

        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.choose)))
            Toast.makeText(this, getString(R.string.sendsucceed), Toast.LENGTH_SHORT).show()
            finish()
        } catch(e:Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}