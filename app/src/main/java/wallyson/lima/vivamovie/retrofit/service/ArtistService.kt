package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import wallyson.lima.vivamovie.model.Person

interface ArtistService {
    @GET("artists")
    fun getAllArtists(): Call<List<Person>>
}