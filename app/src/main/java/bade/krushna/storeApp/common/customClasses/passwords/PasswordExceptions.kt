package bade.krushna.storeApp.common.customClasses.passwords


sealed class PasswordExceptions(override val message : String?) : Exception(){
    class PasswordBlank : PasswordExceptions(
        "Password cannot be blank"
    )

    class PasswordLessThan8 : PasswordExceptions(
        "Minimum length of Password must be 8"
    )

    class PasswordShouldHaveSpecialChar : PasswordExceptions(
        "Minimum 1 special character is required in password"
    )
}
