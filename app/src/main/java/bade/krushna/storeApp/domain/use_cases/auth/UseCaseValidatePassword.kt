package bade.krushna.storeApp.domain.use_cases.auth

import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.passwords.TextPassword
import bade.krushna.storeApp.common.customClasses.passwords.TokenPassword
import bade.krushna.storeApp.presentation.ui.views.auth.sign_in.LoginEvents


class UseCaseValidatePassword {

    operator fun invoke(
        loginEvents: LoginEvents.ValidatePassword
    ): Status? {
        return when (loginEvents.type) {
            is TextPassword -> {
                TextPassword.init(
                    (loginEvents).password
                )
            }

            is TokenPassword -> {
                TokenPassword.init(
                    (loginEvents).password
                )
            }

            else -> {
                null
            }
        }
    }
}