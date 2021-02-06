package wallyson.lima.vivamovie.model

class Artist {
    private lateinit var name : String
    private lateinit var knowForDepartment : String
    private lateinit var birthday : String
    private lateinit var placeOfBirthday : String
    private lateinit var biography : String
    private lateinit var popularity : Integer

    constructor(name : String, knowForDepartment : String, birthday : String,
                placeOfBirthday : String, biography : String, popularity : Integer) {
        this.name = name
        this.knowForDepartment = knowForDepartment
        this.birthday = birthday
        this.placeOfBirthday = placeOfBirthday
        this.biography = biography
        this.popularity = popularity
    }
}