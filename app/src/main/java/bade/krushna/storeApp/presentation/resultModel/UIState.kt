package bade.krushna.storeApp.presentation.resultModel

data class UIState<T>(
    val isLoading : Boolean = false,
    val error : Exception? = null,
    val data : T? = null,
    val isSuccess : Boolean = false
)
