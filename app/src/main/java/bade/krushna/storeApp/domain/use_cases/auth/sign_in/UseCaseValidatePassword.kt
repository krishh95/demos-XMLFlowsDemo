package bade.krushna.storeApp.domain.use_cases.auth.sign_in

import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.passwords.TextPassword
import bade.krushna.storeApp.common.customClasses.passwords.TokenPassword
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInEvents


class UseCaseValidatePassword {

    operator fun invoke(
        signInEvents: SignInEvents.ValidatePassword
    ): Status? {
        return when (signInEvents.type) {
            is TextPassword -> {
                TextPassword.init(
                    (signInEvents).password
                )
            }

            is TokenPassword -> {
                TokenPassword.init(
                    (signInEvents).password
                )
            }

            else -> {
                null
            }
        }
    }
}