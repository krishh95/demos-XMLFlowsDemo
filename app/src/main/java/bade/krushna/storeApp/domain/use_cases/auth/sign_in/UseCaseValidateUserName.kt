package bade.krushna.storeApp.domain.use_cases.auth.sign_in

import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.field.StringField
import bade.krushna.storeApp.presentation.ui.auth.sign_in.SignInEvents

class UseCaseValidateUserName {
    operator fun invoke(
        signInEvents: SignInEvents.ValidateUserName
    ): Status {
        return StringField.init(signInEvents.username)
    }
}