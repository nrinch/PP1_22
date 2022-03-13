package na.severinchik.lesson5.domain.interactor

import na.severinchik.lesson5.domain.usecase.AddUserUseCase
import na.severinchik.lesson5.domain.usecase.GetUserUseCase

class UserInteractor(
    private val addUserUseCase: AddUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : AddUserUseCase by addUserUseCase,
    GetUserUseCase by getUserUseCase {
}