package com.sefio.suay.domain.model

import com.google.gson.JsonObject

class JsonObjectWrapper(val jsonObject: JsonObject): JsonWrapper() {

    fun has(fieldName:String):Boolean {
        return jsonObject.has(fieldName)
    }

    fun getString(fieldName: String): String {
        return if (has(fieldName)) {
            jsonObject.get(fieldName).asString
        } else {
            throw Exception("Parse Error")
        }
    }

    fun optString(fieldName: String): String {
        return if (has(fieldName)) {
            jsonObject.get(fieldName).asString
        } else {
            ""
        }
    }

    fun getJsonObjectWrapper(fieldName: String): JsonObjectWrapper {
        return if (has(fieldName))
                    JsonObjectWrapper(jsonObject.getAsJsonObject(fieldName))
                else
                    throw Exception("unknown data")
    }


    fun getJsonArrayWrapper(fieldName: String):JsonArrayWrapper {
        return if (has(fieldName))
            JsonArrayWrapper(jsonObject.getAsJsonArray(fieldName))
        else
            throw Exception("unknown data")
    }

    fun getDouble(fieldName: String): Double {
        return if (has(fieldName))
                    jsonObject.get(fieldName).asDouble
                else
                    throw Exception("Unknown data")
    }

    fun optDouble(fieldName: String): Double? {
        return return if (has(fieldName))
            jsonObject.get(fieldName).asDouble
        else null
    }

    fun getInt(fieldName: String): Int {
        return if (has(fieldName))
            jsonObject.get(fieldName).asInt
        else
            throw Exception("Unknown data")
    }

}