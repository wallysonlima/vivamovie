package wallyson.lima.vivamovie.model

class Movie {
    private lateinit var title : String
    private lateinit var popularity : Integer
    private lateinit var posterPath : String
    private lateinit var releaseDate : String
    private lateinit var nameCompanie : String
    private lateinit var nameGenre : String

    constructor(title : String, popularity : Integer, posterPath : String, releaseDate : String,
                nameCompanie : String, nameGenre : String) {
        this.title = title
        this.popularity = popularity
        this.posterPath = posterPath
        this.releaseDate = releaseDate
        this.nameCompanie = nameCompanie
        this.nameGenre = nameGenre
    }
}