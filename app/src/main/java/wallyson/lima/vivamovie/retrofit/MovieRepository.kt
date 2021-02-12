package wallyson.lima.vivamovie.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wallyson.lima.vivamovie.model.GetMoviesResponse
import wallyson.lima.vivamovie.model.Movie
import wallyson.lima.vivamovie.retrofit.service.MovieService

object MovieRepository {
    private val movieService: MovieService

    init {
            val client by lazy {
                val interceptador = HttpLoggingInterceptor()
                interceptador.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder()
                    .addInterceptor(interceptador)
                    .build()
            }

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

            movieService = retrofit.create(MovieService::class.java)
        }

        fun getAllMovies(
             page: Int = 1,
             onSuccess: (movies: List<Movie>) -> Unit,
             onError: () -> Unit)
        {
                movieService.getAllMovies(page = page)
                .enqueue(object : Callback<GetMoviesResponse> {
                    override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                    ) {
                        if ( response.isSuccessful ) {
                            val responseBody = response.body()

                            if ( responseBody != null ) {
                                onSuccess.invoke(responseBody.movies)
                            } else {
                                onError.invoke()
                            }
                        } else {
                            onError.invoke()
                        }
                    }

                    override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                        onError.invoke()
                    }
                })
        }

    fun getAllMarvelMovies(page: Int = 1,
                           onSuccess: (movies: List<Movie>) -> Unit,
                           onError: () -> Unit)
    {
            movieService.getAllMarvelMovies(page = page)
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if ( response.isSuccessful ) {
                        val responseBody = response.body()

                        if ( responseBody != null ) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getAllTopMovies(page: Int = 1,
                        onSuccess: (movies: List<Movie>) -> Unit,
                        onError: () -> Unit)
    {
            movieService.getAllMoviesTopRated(page = page)
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if ( response.isSuccessful ) {
                        val responseBody = response.body()

                        if ( responseBody != null ) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}