package bade.krushna.storeApp.data.repository

import bade.krushna.storeApp.data.remote.IApiServices
import bade.krushna.storeApp.data.remote.dto.LoginResponseDTO
import bade.krushna.storeApp.data.remote.requestModels.SignInRequest
import bade.krushna.storeApp.domain.repository.ILogin
import javax.inject.Inject

class LoginImpl @Inject constructor(
    val apiInterface : IApiServices
) : ILogin {
    override suspend fun login(loginRequest: SignInRequest): LoginResponseDTO {
        return apiInterface.login(loginRequest)
    }
}