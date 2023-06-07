package com.sefio.suay.data.remote

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.sefio.suay.data.remote.api.BackApi
import com.sefio.suay.domain.model.JsonArrayWrapper
import com.sefio.suay.domain.model.JsonObjectWrapper
import com.sefio.suay.domain.model.ResponseObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.Path
import retrofit2.http.QueryMap
import javax.inject.Inject

class ApiExecutor @Inject constructor(
    private val backAPi:BackApi
) {

    fun executePost(endpoint:String, body:JsonElement): JsonObjectWrapper {
        return JsonObjectWrapper(executePostResponse(endpoint = endpoint, body = body).obj.asJsonObject)
    }

    fun executeArrayPost(endpoint: String, body: JsonElement): JsonArrayWrapper {
        return JsonArrayWrapper(executePostResponse(endpoint = endpoint, body = body).obj.asJsonArray)
    }

    private fun executePostResponse(endpoint: String, body: JsonElement = JsonObject(), params:Map<String,String> = mapOf()): ResponseObject<JsonElement> {
        val request = backAPi.create(PostRequestService::class.java).executeRequest(endpoint, body, params)

        val response = request.execute()

        if (response.isSuccessful) {
            return ResponseObject(JsonParser().parse(response.body()?.string()))
        }

        val error = JsonParser().parse(response.errorBody()?.string()).asJsonObject

        throw Exception(error.get("message").asString)
    }

    private interface PostRequestService {

        @HTTP(method = "POST", path = "{path}", hasBody = true)
        fun executeRequest(@Path("path") path:String, @Body body:JsonElement, @QueryMap params:Map<String,String>): Call<ResponseBody>
    }

}