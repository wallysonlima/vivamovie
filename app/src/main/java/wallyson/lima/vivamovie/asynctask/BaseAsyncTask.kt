package wallyson.lima.vivamovie.asynctask

import android.os.AsyncTask

class BaseAsyncTask<T>(
    private val quandoExecuta: () -> T,
    private val quandoFinaliza: (resultado: T) -> Unit
) : AsyncTask<Void, Void, T>() {

    override fun doInBackground(vararg params: Void?) = quandoExecuta()

    override fun onPostExecute(resultado: T) {
        super.onPostExecute(resultado)
        quandoFinaliza(resultado)
    }

}