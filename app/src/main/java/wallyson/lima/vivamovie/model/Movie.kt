package wallyson.lima.vivamovie.model

import androidx.room.Entity

@Entity
class Movie {
    private lateinit var title : String
    private lateinit var popularity : Integer
    private lateinit var posterPath : String
    private lateinit var releaseDate : String
    private lateinit var nameCompany : String
    private lateinit var nameGenre : String

    constructor(title : String, popularity : Integer, posterPath : String, releaseDate : String,
                nameCompany : String, nameGenre : String) {
        this.title = title
        this.popularity = popularity
        this.posterPath = posterPath
        this.releaseDate = releaseDate
        this.nameCompany = nameCompany
        this.nameGenre = nameGenre
    }
}