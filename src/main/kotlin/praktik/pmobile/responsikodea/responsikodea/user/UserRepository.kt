package praktik.pmobile.responsikodea.responsikodea.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByUsernameAndPassword(username: String, password: String): User?
    fun findByUsername(username: String): User?
    fun findAllByRole(role: Role): List<User>
}