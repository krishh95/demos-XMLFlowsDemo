package bade.krushna.storeApp.common.customClasses

sealed class Status{
    class Success<T>(val data : T):Status()
    class Failed(val error: Exception):Status()
}