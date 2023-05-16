package com.sefio.suay.domain.model

import com.google.gson.JsonArray

class JsonArrayWrapper(
    val jsonArray: JsonArray,
    ): JsonWrapper() {

    fun getJsonAtPos(pos:Int): JsonObjectWrapper {
        try {
            return JsonObjectWrapper(jsonObject = jsonArray.get(pos).asJsonObject)
        } catch (e:Exception) {
            throw Exception("Parse error")
        }
    }

    fun getStringArray(): List<String> {
        return jsonArray.map {
            jsonElement -> jsonElement.asString
        }
    }

}