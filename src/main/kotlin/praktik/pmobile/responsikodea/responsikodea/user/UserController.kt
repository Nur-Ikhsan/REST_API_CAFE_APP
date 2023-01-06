package praktik.pmobile.responsikodea.responsikodea.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping(
        value = ["/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(@RequestBody loginRequest: LoginRequest): User {
        return userService.login(loginRequest)
    }

    @PostMapping(
        value = ["/register"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun register(@RequestBody registerRequest: RegisterRequest): User {
        return userService.register(registerRequest)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = ["application/json"]
    )
    fun delete(@PathVariable id: Long): ResponseEntity<Map<String, Boolean>> {
        userService.delete(id)
        val response = mapOf("deleted" to true)
        return ResponseEntity.ok(response)
    }

    @PutMapping(
        value = ["/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun update(@PathVariable id: Long, @RequestBody updateRequest: UpdateRequest): User {
        return userService.update(id, updateRequest)
    }

    @GetMapping(
        value = ["/employees"],
        produces = ["application/json"]
    )
    fun getAllEmployee(): List<User> {
        return userService.getAllEmployee()
    }
}
