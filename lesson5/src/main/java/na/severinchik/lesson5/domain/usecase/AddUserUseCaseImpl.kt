package na.severinchik.lesson5.domain.usecase

import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.domain.repositories.UserRepository

class AddUserUseCaseImpl(private val userRepository: UserRepository) : AddUserUseCase {
    override suspend fun add(user: User) {
        userRepository.add(user)
    }
}