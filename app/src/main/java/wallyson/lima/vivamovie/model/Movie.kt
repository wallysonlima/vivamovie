package wallyson.lima.vivamovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Movie {
    @PrimaryKey(autoGenerate = true)
    private var id : Int = 0
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

    fun getPosterPath(): String {
        return this.posterPath
    }

    fun getTitle(): String {
        return this.title
    }

    fun getPopularity(): Integer {
        return this.popularity
    }

    fun getReleaseDate() : String {
        return this.releaseDate
    }
}