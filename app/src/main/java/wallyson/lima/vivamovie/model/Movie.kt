package wallyson.lima.vivamovie.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class Movie (
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    var title : String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var posterPath : String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("vote_average")
    var rating : Float,
    @SerializedName("release_date")
    var releaseDate : String
)