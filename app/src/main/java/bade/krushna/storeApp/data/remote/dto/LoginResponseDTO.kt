package bade.krushna.storeApp.data.remote.dto


import android.os.Parcelable
import bade.krushna.storeApp.domain.model.LoginResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponseDTO(
    @SerializedName("token")
    val token: String = ""
) : Parcelable{
    fun toLoginResponse() : LoginResponse {
        return LoginResponse(
            token = token
        )
    }
}