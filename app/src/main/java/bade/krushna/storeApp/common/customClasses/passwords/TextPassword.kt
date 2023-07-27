package bade.krushna.storeApp.common.customClasses.passwords

import bade.krushna.storeApp.Regexes.SPECIAL_CHAR_MATCHING_REGEX
import bade.krushna.storeApp.common.customClasses.Status
import bade.krushna.storeApp.common.lessThan
import kotlin.jvm.Throws

class TextPassword private constructor(
    override val password : String
): IPassword {

    companion object{
        @Synchronized
        @JvmStatic
        @Throws(Exception::class)
        fun init(passwordToBe : String) : Status {
            if(passwordToBe.isBlank())
                return Status.Failed(
                    PasswordExceptions.PasswordBlank()
                )

            if(passwordToBe.lessThan(8))
                return Status.Failed(
                    PasswordExceptions.PasswordLessThan8()
                )

            if(!passwordToBe.contains(Regex(SPECIAL_CHAR_MATCHING_REGEX)))
                return Status.Failed(
                    PasswordExceptions.PasswordShouldHaveSpecialChar()
                )

            return Status.Success(
                TextPassword(passwordToBe)
            )
        }
    }


}


