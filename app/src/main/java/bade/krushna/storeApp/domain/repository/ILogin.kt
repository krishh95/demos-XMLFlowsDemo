package bade.krushna.storeApp.domain.repository

import bade.krushna.storeApp.data.remote.dto.LoginResponseDTO
import bade.krushna.storeApp.data.remote.requestModels.LoginRequest
import bade.krushna.storeApp.domain.model.LoginResponse

interface ILogin {
    suspend fun login(loginRequest: LoginRequest) : LoginResponseDTO
}