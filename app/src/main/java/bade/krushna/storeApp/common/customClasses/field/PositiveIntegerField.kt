package bade.krushna.storeApp.common.customClasses.field

import bade.krushna.storeApp.common.customClasses.Status
import kotlin.jvm.Throws

class PositiveIntegerField private constructor(
    override var field: Any
) : IField {

    companion object{
        @Synchronized
        @JvmStatic
        @Throws(Exception::class)
         fun init(field : Int?) : Status {
            if(field == null || field <= 0 ){
                return Status.Failed(
                    FieldExceptions.FieldNotPositiveException()
                )
            }

            return Status.Success(
                PositiveIntegerField(
                    field
                )
            )
        }
    }
}