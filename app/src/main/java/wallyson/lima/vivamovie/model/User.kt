package wallyson.lima.vivamovie.model

class User {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String

    constructor(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
    }
}