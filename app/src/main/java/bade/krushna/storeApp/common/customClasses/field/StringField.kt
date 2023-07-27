package bade.krushna.storeApp.common.customClasses.field

import bade.krushna.storeApp.common.customClasses.Status
import kotlin.jvm.Throws

class StringField private constructor(
    override val field : String
) : IField {


    companion object{

        @Synchronized
        @JvmStatic
        @Throws(Exception::class)
        fun init(field : String?) : Status {
            if(field.isNullOrBlank()){
                return Status.Failed(
                    FieldExceptions.FieldEmptyException()
                )
            }

            return Status.Success(
                StringField(
                    field
                )
            )
        }
    }
}