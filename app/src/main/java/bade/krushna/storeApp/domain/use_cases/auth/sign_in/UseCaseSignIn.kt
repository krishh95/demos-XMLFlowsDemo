package bade.krushna.storeApp.domain.use_cases.auth.sign_in

import bade.krushna.storeApp.data.remote.requestModels.LoginRequest
import bade.krushna.storeApp.data.repository.LoginImpl
import bade.krushna.storeApp.domain.model.LoginResponse
import javax.inject.Inject

class UseCaseSignIn @Inject constructor(
    val loginImpl: LoginImpl
) {
    suspend operator fun invoke(loginRequest: LoginRequest):LoginResponse{
        return loginImpl.login(loginRequest).toLoginResponse()
    }
}