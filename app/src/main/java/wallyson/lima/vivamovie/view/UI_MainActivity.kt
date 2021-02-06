package wallyson.lima.vivamovie.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import wallyson.lima.vivamovie.R

class UI_MainActivity : AppCompatActivity() {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var editTextName: EditText
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
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun cleanInput() {
        editTextName.setText("")
        editTextPassword.setText("")
    }

    fun register() {
        val intent = Intent(this, UI_RegisterActivity::class.java)
        startActivity(intent)
    }
}