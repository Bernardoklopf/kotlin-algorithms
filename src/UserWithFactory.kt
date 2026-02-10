class User private constructor(val name: String) { // Private constructor!

    // This acts as the Factory
    companion object {
        fun createFromEmail(email: String): User {
            val nickname = email.substringBefore("@")
            return User(nickname)
        }

        fun createGuest(): User {
            return User("Guest")
        }
    }
}

// Usage:
val user = User.createFromEmail("john@example.com")