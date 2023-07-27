package bade.krushna.storeApp.domain.use_cases.auth

import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.field.StringField
import bade.krushna.storeApp.presentation.ui.views.auth.sign_in.LoginEvents

class UseCaseValidateUserName {
    operator fun invoke(
        loginEvents: LoginEvents.ValidateUserName
    ): Status {
        return StringField.init(loginEvents.username)
    }
}