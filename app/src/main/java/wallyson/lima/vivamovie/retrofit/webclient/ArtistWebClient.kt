package wallyson.lima.vivamovie.retrofit.webclient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import wallyson.lima.vivamovie.model.Artist
import wallyson.lima.vivamovie.retrofit.AppRetrofit
import wallyson.lima.vivamovie.retrofit.service.ArtistService

private const val INVALID_REQUISITION = "Requisition not succeed !"

class ArtistWebClient(
    private val service: ArtistService = AppRetrofit().artistService) {
        private fun <T> executeRequisition(
            call: Call<T>,
            succeed: (artistNew: T?) -> Unit,
            fail: (error: String?) -> Unit
        ) {
            call.enqueue(object: Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    if (response.isSuccessful) {
                        succeed(response.body())
                    } else {
                        fail(INVALID_REQUISITION)
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    fail(t.message)
                }
            })
        }

        fun getAllArtists(
            succeed: (artistNew: List<Artist>?) -> Unit,
            fail: (error: String?) -> Unit
        ) {
            executeRequisition(
                service.getAllArtists(),
                succeed,
                fail
            )
        }
    }