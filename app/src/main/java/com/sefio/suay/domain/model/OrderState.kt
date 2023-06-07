package com.sefio.suay.domain.model

enum class OrderState(val value:String, val code:Int) {
    SAVED("Guardado", 0),
    PROCESSING("Orden en progreso", 1),
    BOUGHT("Comprado", 2);

    companion object {
        @JvmStatic
        fun buildForCode(code: Int): OrderState {
            return values().first { it.code == code }
        }
    }
}
