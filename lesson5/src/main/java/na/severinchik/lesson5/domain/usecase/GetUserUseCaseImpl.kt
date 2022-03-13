package na.severinchik.lesson5.domain.usecase

import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.domain.repositories.UserRepository

class GetUserUseCaseImpl(private val userRepository: UserRepository) : GetUserUseCase {
    override suspend fun getAll(): List<User> = userRepository.getAll()

    override suspend fun getById(id: Int): List<User> = userRepository.getById(id)
}