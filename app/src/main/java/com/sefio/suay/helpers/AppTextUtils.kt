package com.sefio.suay.helpers

import javax.annotation.Nullable

abstract class AppTextUtils {

    companion object {
        @JvmStatic
        fun isEmpty(value:String?):Boolean {
            return value == null || value == ""
        }
    }
}