package na.severinchik.lesson5.domain.usecase

import na.severinchik.lesson5.data.entities.User

interface GetUserUseCase {
    suspend fun getAll(): List<User>
    suspend fun getById(id: Int): List<User>
}