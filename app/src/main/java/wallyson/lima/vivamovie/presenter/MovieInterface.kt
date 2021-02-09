package wallyson.lima.vivamovie.presenter

interface MovieInterface {
    public fun getAllMovies()
    public fun getAllMoviesOrderAsc()
    public fun getAllMoviesByCompany(nameCompany : String)
    public fun getAllBestMovies()
    public fun getAllNewMovies()
}