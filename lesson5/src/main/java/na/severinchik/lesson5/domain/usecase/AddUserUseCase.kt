package na.severinchik.lesson5.domain.usecase

import na.severinchik.lesson5.data.entities.User

interface AddUserUseCase {
    suspend fun add(user: User)
}