package wallyson.lima.vivamovie.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.MainInterface
import wallyson.lima.vivamovie.presenter.MainPresenter
import wallyson.lima.vivamovie.presenter.RegisterPresenter

class UI_MainActivity : AppCompatActivity(), MainInterface {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var mPresenter : MainPresenter

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

        btnLogin.setOnClickListener {
            login()
        }
    }

    fun initialize() {
        btnClean = findViewById(R.id.buttonClean)
        btnLogin = findViewById(R.id.buttonLogin)
        btnRegister = findViewById(R.id.buttonRegister)
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        mPresenter = MainPresenter( this, applicationContext )
    }

    fun cleanInput() {
        editTextName.setText("")
        editTextPassword.setText("")
    }

    fun register() {
        val intent = Intent(this, UI_RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun login() {
        if ( mPresenter.login() ) {
            Toast.makeText(this, getString(R.string.successlogin), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, UI_MainOptionsActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.errorlogin), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getName() : String {
        return this.editTextName.getText().toString()
    }

    override fun getPassword() : String {
        return this.editTextPassword.getText().toString()
    }
}