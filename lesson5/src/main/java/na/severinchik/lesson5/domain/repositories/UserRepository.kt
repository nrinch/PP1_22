package na.severinchik.lesson5.domain.repositories

import na.severinchik.lesson5.data.entities.User

interface UserRepository {

    suspend fun add(user: User)

    suspend fun getAll(): List<User>

    suspend fun getById(id: Int): List<User>

}