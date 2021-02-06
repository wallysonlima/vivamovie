package wallyson.lima.vivamovie.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.RegisterInterface
import wallyson.lima.vivamovie.presenter.RegisterPresenter
import java.security.AccessController.getContext

class UI_RegisterActivity : AppCompatActivity(), RegisterInterface {
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonClean: Button
    private lateinit var mPresenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initialize()

        buttonClean.setOnClickListener{
            clean();
        }

        buttonRegister.setOnClickListener {
            toRegister()
        }
    }

    fun initialize() {
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonClean = findViewById(R.id.buttonClean)
        mPresenter = RegisterPresenter( this, applicationContext )
    }

    fun clean() {
        editTextName.setText("")
        editTextPassword.setText("")
    }

    override fun toRegister() {
        if ( mPresenter.toRegister() ) {
            Toast.makeText(this, getString(R.string.successregister), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, UI_MainOptionsActivity::class.java)
            startActivity(intent)
        } else {
            if ( editTextName.text.isNotEmpty() && editTextPassword.text.isNotEmpty() ) {
                Toast.makeText(this, getString(R.string.fill), Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(this, getString(R.string.usererror), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getName() : String {
        return this.editTextName.toString()
    }

    override fun getPassword() : String {
        return this.editTextPassword.toString()
    }
}