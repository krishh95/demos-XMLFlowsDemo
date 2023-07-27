package bade.krushna.storeApp.common.customClasses.passwords

import bade.krushna.storeApp.common.customClasses.Status
import kotlin.jvm.Throws

class TokenPassword private constructor(
    override val password : String
) : IPassword {
    companion object{

        @Synchronized
        @JvmStatic
        @Throws(Exception::class)
        fun init(passwordToBe : String) : Status{
            return Status.Success(
                TokenPassword(passwordToBe)
            )
        }
    }
}