package wallyson.lima.vivamovie.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
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
import kotlinx.android.synthetic.main.activity_erro.view.*
import wallyson.lima.vivamovie.R
import wallyson.lima.vivamovie.presenter.RegisterInterface
import wallyson.lima.vivamovie.presenter.RegisterPresenter
import java.lang.IllegalStateException
import java.security.AccessController.getContext

class UI_RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}