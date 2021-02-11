package wallyson.lima.vivamovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("title")
    var title : String,
    @SerializedName("popularity")
    var popularity : Integer,
    @SerializedName("posterPath")
    var posterPath : String,
    @SerializedName("releaseDate")
    var releaseDate : String
)