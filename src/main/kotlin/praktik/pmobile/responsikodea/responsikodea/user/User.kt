package praktik.pmobile.responsikodea.responsikodea.user

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var username: String,
    var address: String,
    var phoneNumber: String,
    var password: String,
    @Enumerated(EnumType.STRING)
    val role: Role
) {
    constructor() : this(null, "", "", "", "", "", Role.OWNER) {}
}


