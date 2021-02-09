package wallyson.lima.vivamovie.retrofit.service

import retrofit2.Call
import retrofit2.http.GET
import wallyson.lima.vivamovie.model.Person

interface PersonService {
    @GET("artists")
    fun getAllArtists(): Call<List<Person>>
}