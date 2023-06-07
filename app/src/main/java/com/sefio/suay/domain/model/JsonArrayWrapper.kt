package com.sefio.suay.domain.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject

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

    fun getObjectArray(): List<JsonObjectWrapper> {
        return jsonArray.map {
            JsonObjectWrapper(it.asJsonObject)
        }
    }

}