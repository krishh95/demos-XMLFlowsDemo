package bade.krushna.storeApp.data.remote

import bade.krushna.storeApp.data.remote.dto.LoginResponseDTO
import bade.krushna.storeApp.data.remote.requestModels.SignInRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface IApiServices {

    @POST("/auth/login")
    suspend fun login(
        @Body loginRequest : SignInRequest
    ) : LoginResponseDTO
}