package na.severinchik.lesson5

import android.app.Application
import na.severinchik.lesson5.data.repositories.UserRepositoryImpl
import na.severinchik.lesson5.data.source.local.LocalSource
import na.severinchik.lesson5.domain.interactor.UserInteractor
import na.severinchik.lesson5.domain.repositories.UserRepository
import na.severinchik.lesson5.domain.usecase.AddUserUseCase
import na.severinchik.lesson5.domain.usecase.AddUserUseCaseImpl
import na.severinchik.lesson5.domain.usecase.GetUserUseCase
import na.severinchik.lesson5.domain.usecase.GetUserUseCaseImpl

class App : Application() {

    val isAllTextUpperCase: Boolean = true

    val localSource = LocalSource()
    val userRepository: UserRepository by lazy { UserRepositoryImpl(localSource) }

    val addUserUseCase: AddUserUseCase by lazy { AddUserUseCaseImpl(userRepository) }
    val getUserUseCase: GetUserUseCase by lazy { GetUserUseCaseImpl(userRepository) }

    val userInteractor: UserInteractor by lazy { UserInteractor(addUserUseCase, getUserUseCase) }

    override fun onCreate() {
        super.onCreate()
    }
}