package bade.krushna.storeApp.domain.repository

import bade.krushna.storeApp.data.remote.dto.LoginResponseDTO
import bade.krushna.storeApp.data.remote.requestModels.SignInRequest

interface ILogin {
    suspend fun login(loginRequest: SignInRequest) : LoginResponseDTO
}