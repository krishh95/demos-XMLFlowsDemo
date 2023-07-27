package bade.krushna.storeApp.data.remote.requestModels

import android.os.Parcelable
import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.field.StringField
import bade.krushna.storeApp.common.customClasses.passwords.IPassword
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlin.jvm.Throws

@Parcelize
data class LoginRequest private constructor(
    @SerializedName("username")
    val userName: String = "",

    @SerializedName("password")
    val passWord: String = "",
):Parcelable{

    companion object{
        /*@Synchronized
        @JvmStatic
        @Throws(Exception::class)
        fun <T: StringField>init(userName :  T , passWord : IPassword): Status {

            return Status.Success(
                LoginRequest(
                    userName = userName.field,
                    passWord = passWord.password
                )
            )
        }*/

        @Synchronized
        @JvmStatic
        @Throws(Exception::class)
        fun init(userName : StringField , passWord : IPassword) : LoginRequest {

            return LoginRequest(
                    userName = userName.field,
                    passWord = passWord.password
                )
        }
    }
}