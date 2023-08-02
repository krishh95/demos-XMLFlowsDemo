package bade.krushna.storeApp.presentation.ui.auth.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.field.IField
import bade.krushna.storeApp.common.customClasses.field.StringField
import bade.krushna.storeApp.common.customClasses.passwords.IPassword
import bade.krushna.storeApp.data.remote.requestModels.LoginRequest
import bade.krushna.storeApp.domain.use_cases.auth.sign_in.UseCaseSignIn
import bade.krushna.storeApp.domain.use_cases.auth.sign_in.UseCaseValidatePassword
import bade.krushna.storeApp.domain.use_cases.auth.sign_in.UseCaseValidateUserName
import bade.krushna.storeApp.presentation.resultModel.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    val useCaseLogin: UseCaseSignIn,
    val useCaseValidateUserName : UseCaseValidateUserName,
    val useCaseValidatePassword : UseCaseValidatePassword
): ViewModel() {
    lateinit var password : IPassword
    lateinit var userName : IField

    var _uiState = MutableStateFlow(UIState<Any>())
    val uiState = _uiState.asStateFlow()

    var _validateUserNameState = MutableSharedFlow<UIState<*>>()
    val validateUserNameState = _uiState.asSharedFlow()

    var _validatePasswordState = MutableSharedFlow<UIState<*>>()
    val validatePasswordState = _uiState.asSharedFlow()


    fun onEvent(signInEvents: SignInEvents){
        viewModelScope.launch(Dispatchers.IO) {
            when (signInEvents) {
                is SignInEvents.SignIn -> {

                    _uiState.value = UIState(
                        isLoading = true
                    )

                    kotlin.runCatching {

                        val result = useCaseLogin(
                            LoginRequest.init(
                                userName as StringField,
                                password
                            )
                        )

                        _uiState.emit(
                            UIState(
                                data = result
                            )
                        )

                    }.onFailure {
                        _uiState.emit(
                            UIState(
                                error = Exception(it.cause)
                            )
                        )
                    }
                }

                is SignInEvents.ValidatePassword -> {

                    when (val status = useCaseValidatePassword(signInEvents)) {
                        is Status.Failed -> {
                            _validatePasswordState.emit(
                                UIState<Nothing>(
                                    error = status.error
                                )
                            )
                        }

                        is Status.Success<*> -> {
                            password = status.data as IPassword
                            _validatePasswordState.emit(
                                UIState(
                                    data = status.data
                                )
                            )
                        }

                        else -> {}
                    }

                }

                is SignInEvents.ValidateUserName -> {

                    when (val status = useCaseValidateUserName(signInEvents)) {
                        is Status.Failed -> {
                            _validateUserNameState.emit(
                                UIState<Nothing>(
                                    error = status.error
                                )
                            )
                        }

                        is Status.Success<*> -> {
                            userName = status.data as IField
                            _validateUserNameState.emit(
                                UIState(
                                    data = status.data
                                )
                            )
                        }
                    }
                }
            }
        }
    }


}