package wallyson.lima.vivamovie.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class Movie (
    @SerializedName("title")
    var title : String,
    @SerializedName("popularity")
    var popularity : Int,
    @SerializedName("posterPath")
    var posterPath : String,
    @SerializedName("releaseDate")
    var releaseDate : String
)