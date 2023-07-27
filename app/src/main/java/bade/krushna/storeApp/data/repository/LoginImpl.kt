package bade.krushna.storeApp.data.repository

import bade.krushna.storeApp.data.remote.IApiServices
import bade.krushna.storeApp.data.remote.dto.LoginResponseDTO
import bade.krushna.storeApp.data.remote.requestModels.LoginRequest
import bade.krushna.storeApp.domain.model.LoginResponse
import bade.krushna.storeApp.domain.repository.ILogin
import javax.inject.Inject

class LoginImpl @Inject constructor(
    val apiInterface : IApiServices
) : ILogin {
    override suspend fun login(loginRequest: LoginRequest): LoginResponseDTO {
        return apiInterface.login(loginRequest)
    }
}