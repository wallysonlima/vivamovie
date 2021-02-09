package wallyson.lima.vivamovie.retrofit.webclient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.retrofit.AppRetrofit
import wallyson.lima.vivamovie.retrofit.service.MovieService

private const val INVALID_REQUISITION = "Requisition not succeed !"

class MovieWebClient (
    private val service: MovieService = AppRetrofit().movieService
){
    private fun <T> executeRequisition(
        call: Call<T>,
        succeed: (movieService: T?) -> Unit,
        fail: (error: String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T> {
                if ( response.isSuccessful ) {
                    succeed(response.body())
                } else {
                    fail(INVALID_REQUISITION)
                }
            }

            override fun onFailure(call : Call<T>, t: Throwable) {
                fail(t.message)
            }
        })
    }

    fun getAllMovies(
        succeed: (newMovies: List<Movie>?) -> Unit,
        fail: (error: String?) -> Unit
    ) {
        executeRequisition(
            service.getAllMovies(),
            succeed,
            fail
        )
    }
}