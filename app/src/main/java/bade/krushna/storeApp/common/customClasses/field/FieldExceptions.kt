package bade.krushna.storeApp.common.customClasses.field

sealed class FieldExceptions(exception : String) : Exception(exception) {
    class FieldEmptyException : FieldExceptions(
        "Field Cannot be Empty"
    )

    class FieldNotPositiveException : FieldExceptions(
        "Field Cannot be 0 or less than 0"
    )

}