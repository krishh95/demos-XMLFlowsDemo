package bade.krushna.storeApp.presentation.ui.views.auth.sign_in

import bade.krushna.storeApp.common.customClasses.field.IField
import bade.krushna.storeApp.common.customClasses.passwords.IPassword
import kotlin.reflect.KClass

sealed class LoginEvents {
    class Login(val username : IField , val password : IPassword) : LoginEvents()
    class ValidateUserName(val username : String) : LoginEvents()
    class ValidatePassword(val password : String , val type : IPassword) : LoginEvents()
}