package com.sefio.suay.domain.model

import com.google.gson.JsonArray

class JsonArrayWrapper(
    val jsonArray: JsonArray,
    ) {

    fun getJsonAtPos(pos:Int): JsonObjectWrapper {
        try {
            return JsonObjectWrapper(jsonObject = jsonArray.get(pos).asJsonObject)
        } catch (e:Exception) {
            throw Exception("Parse error")
        }
    }

}