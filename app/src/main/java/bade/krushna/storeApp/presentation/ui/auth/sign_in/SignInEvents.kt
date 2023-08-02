package bade.krushna.storeApp.presentation.ui.auth.sign_in

import bade.krushna.storeApp.common.customClasses.field.IField
import bade.krushna.storeApp.common.customClasses.passwords.IPassword

sealed class SignInEvents {
    class SignIn(val username : IField, val password : IPassword) : SignInEvents()
    class ValidateUserName(val username : String) : SignInEvents()
    class ValidatePassword(val password : String , val type : IPassword) : SignInEvents()
}