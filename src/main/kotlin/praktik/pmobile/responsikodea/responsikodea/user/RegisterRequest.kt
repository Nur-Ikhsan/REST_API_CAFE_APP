package praktik.pmobile.responsikodea.responsikodea.user

import jakarta.validation.constraints.NotBlank

data class RegisterRequest (
    val id: Long? = null,
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val username: String,
    @field:NotBlank
    val address: String,
    @field:NotBlank
    val phoneNumber: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val role: String
)