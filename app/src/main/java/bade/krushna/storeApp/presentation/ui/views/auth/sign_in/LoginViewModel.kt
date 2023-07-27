package bade.krushna.storeApp.presentation.ui.views.auth.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bade.krushna.storeApp.common.customClasses.State
import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.customClasses.field.IField
import bade.krushna.storeApp.common.customClasses.field.StringField
import bade.krushna.storeApp.common.customClasses.passwords.IPassword
import bade.krushna.storeApp.data.remote.requestModels.LoginRequest
import bade.krushna.storeApp.domain.use_cases.auth.UseCaseLogin
import bade.krushna.storeApp.domain.use_cases.auth.UseCaseValidatePassword
import bade.krushna.storeApp.domain.use_cases.auth.UseCaseValidateUserName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val useCaseLogin: UseCaseLogin,
    val useCaseValidateUserName : UseCaseValidateUserName,
    val useCaseValidatePassword : UseCaseValidatePassword
): ViewModel() {
    lateinit var password : IPassword
    lateinit var userName : IField

    var _uiState = MutableStateFlow(State<Any>())
    val uiState = _uiState.asStateFlow()

    var _validateUserNameState = MutableSharedFlow<State<*>>()
    val validateUserNameState = _uiState.asSharedFlow()

    var _validatePasswordState = MutableSharedFlow<State<*>>()
    val validatePasswordState = _uiState.asSharedFlow()


    fun onEvent(loginEvents: LoginEvents){
        viewModelScope.launch(Dispatchers.IO) {
            when (loginEvents) {
                is LoginEvents.Login -> {

                    _uiState.value = State(
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
                            State(
                                data = result
                            )
                        )

                    }.onFailure {
                        _uiState.emit(
                            State(
                                error = Exception(it.cause)
                            )
                        )
                    }
                }

                is LoginEvents.ValidatePassword -> {

                    when (val status = useCaseValidatePassword(loginEvents)) {
                        is Status.Failed -> {
                            _validatePasswordState.emit(
                                State<Nothing>(
                                    error = status.error
                                )
                            )
                        }

                        is Status.Success<*> -> {
                            password = status.data as IPassword
                            _validatePasswordState.emit(
                                State(
                                    data = status.data
                                )
                            )
                        }

                        else -> {}
                    }

                }

                is LoginEvents.ValidateUserName -> {

                    when (val status = useCaseValidateUserName(loginEvents)) {
                        is Status.Failed -> {
                            _validateUserNameState.emit(
                                State<Nothing>(
                                    error = status.error
                                )
                            )
                        }

                        is Status.Success<*> -> {
                            userName = status.data as IField
                            _validateUserNameState.emit(
                                State(
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