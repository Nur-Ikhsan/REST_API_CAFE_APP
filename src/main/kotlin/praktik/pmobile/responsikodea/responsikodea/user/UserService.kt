package praktik.pmobile.responsikodea.responsikodea.user

import org.springframework.stereotype.Service
import praktik.pmobile.responsikodea.responsikodea.util.ValidationUtil

@Service
class UserService(private val userRepository: UserRepository, private val validationUtil: ValidationUtil) {

    fun login(loginRequest: LoginRequest): User {
        validationUtil.validate(loginRequest)
        return userRepository.findByUsernameAndPassword(loginRequest.username, loginRequest.password)
            ?: throw Exception("Username atau password salah")
    }

    fun register(registerRequest: RegisterRequest): User {
        validationUtil.validate(registerRequest)
        val existingUser = userRepository.findByUsername(registerRequest.username)
        if (existingUser != null) {
            throw Exception("Username sudah terdaftar")
        }
        val user = User(
            id = registerRequest.id,
            name = registerRequest.name,
            username = registerRequest.username,
            address = registerRequest.address,
            phoneNumber = registerRequest.phoneNumber,
            password = registerRequest.password,
            role = Role.valueOf(registerRequest.role)
        )

        return userRepository.save(user)
    }

    fun delete(id: Long) {
        val user = userRepository.findById(id)
        if (user.isPresent) {
            userRepository.delete(user.get())
        } else {
            throw Exception("User tidak ditemukan")
        }
    }

    fun update(id: Long, updateRequest: UpdateRequest): User {
        val existingUser = userRepository.findById(id)
        if (existingUser.isPresent) {
            val updatedUser = existingUser.get()
            updatedUser.apply {
                name = updateRequest.name
                username = updateRequest.username
                address = updateRequest.address
                phoneNumber = updateRequest.phoneNumber
                password = updateRequest.password
            }
            return userRepository.save(updatedUser)
        } else {
            throw Exception("User tidak ditemukan")
        }
    }

    fun getAllEmployee(): List<User> {
        return userRepository.findAllByRole(Role.EMPLOYEE)
    }

}
