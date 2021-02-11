package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.view.*
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.MainInterface
import wallyson.lima.vivamovie.presenter.MainPresenter
import wallyson.lima.vivamovie.presenter.RegisterInterface
import wallyson.lima.vivamovie.presenter.RegisterPresenter

class UI_MainActivity : AppCompatActivity(), MainInterface, RegisterInterface {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var mPresenter : MainPresenter
    private lateinit var mPresenterRegister : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        btnClean.setOnClickListener {
            cleanInput();
        }

        btnRegister.setOnClickListener {
            toRegister()
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
        mPresenterRegister = RegisterPresenter(this, applicationContext)
    }

    fun cleanInput() {
        editTextName.setText("")
        editTextPassword.setText("")
    }

    override fun toRegister() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_register, null)

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mDialogView.buttonRegister.setOnClickListener {
            val name = mDialogView.editTextName.text.toString()
            val password = mDialogView.editTextPassword.text.toString()

            this.editTextName.setText(name)
            this.editTextPassword.setText(password)

            if ( mPresenterRegister.toRegister() ) {
                Toast.makeText(this, getString(R.string.successregister), Toast.LENGTH_SHORT).show()
                mAlertDialog.dismiss()

                val intent = Intent(this, UI_MainOptionsActivity::class.java)
                startActivity(intent)
            } else {
                if ( editTextName.text.isEmpty() || editTextPassword.text.isEmpty() ) {
                    Toast.makeText(this, getString(R.string.fill), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.usererror), Toast.LENGTH_SHORT).show()
                }
            }
        }

        mDialogView.buttonCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }
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