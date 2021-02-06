package wallyson.lima.vivamovie.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.RegisterInterface
import wallyson.lima.vivamovie.presenter.RegisterPresenter
import java.security.AccessController.getContext

class UI_RegisterActivity(context: Context) : Dialog(context), RegisterInterface {
    private lateinit var editTextName: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonClean: Button
    private lateinit var mPresenter : RegisterPresenter

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
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
        mPresenter = RegisterPresenter( this, context )
    }

    fun clean() {
        editTextName.setText("")
        editTextPassword.setText("")
    }

    override fun toRegister() {
        mPresenter.toRegister()
    }

    override fun getName() : String {
        return this.editTextName.toString()
    }

    override fun getPassword() : String {
        return this.editTextPassword.toString()
    }
}