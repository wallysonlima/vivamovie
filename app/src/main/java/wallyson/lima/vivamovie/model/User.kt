package wallyson.lima.vivamovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey(autoGenerate = true)
    private lateinit var name: String
    private lateinit var password: String

    constructor(name: String, password: String) {
        this.name = name
        this.password = password
    }

    fun getName(): String? {
        return this.name
    }

    fun getPassword(): String? {
        return this.password
    }
}