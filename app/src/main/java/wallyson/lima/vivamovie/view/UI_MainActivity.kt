package wallyson.lima.vivamovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import wallyson.lima.vivamovie.R

class UI_MainActivity : AppCompatActivity() {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var btnFacebook: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        btnClean.setOnClickListener {
            cleanInput();
        }

        btnRegister.setOnClickListener {
            register()
        }
    }

    fun initialize() {
        btnClean = findViewById(R.id.buttonClean)
        btnLogin = findViewById(R.id.buttonLogin)
        btnRegister = findViewById(R.id.buttonRegister)
        btnFacebook = findViewById(R.id.buttonFacebook)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun cleanInput() {
        editTextEmail.setText("")
        editTextPassword.setText("")
    }

    fun register() {
        if ( !editTextEmail.equals("") && editTextPassword.equals("") ) {

        } else {
            Toast.makeText(this, getResources().getString(R.string.fill), Toast.LENGTH_SHORT).show()
        }
    }
}