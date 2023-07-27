package bade.krushna.storeApp.common.customClasses

data class State<T>(
    val isLoading : Boolean = false,
    val error : Exception? = null,
    val data : T? = null,
    val isSuccess : Boolean = false
)
