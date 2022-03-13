package na.severinchik.lesson5.data.repositories

import na.severinchik.lesson5.data.entities.User
import na.severinchik.lesson5.data.source.local.LocalSource
import na.severinchik.lesson5.domain.repositories.UserRepository

class UserRepositoryImpl(private val localSource: LocalSource) : UserRepository {
    override suspend fun add(user: User) {
        localSource.add(user)
    }

    override suspend fun getAll(): List<User> = localSource.getAll()

    override suspend fun getById(id: Int): List<User> = localSource.getById(id)
}