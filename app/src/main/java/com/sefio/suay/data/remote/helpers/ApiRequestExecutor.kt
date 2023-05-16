package com.sefio.suay.data.remote.helpers

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sefio.suay.data.remote.back.BackApi
import com.sefio.suay.domain.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.Path
import retrofit2.http.QueryMap
import javax.inject.Inject

class ApiRequestExecutor @Inject constructor(
    private val backApi: BackApi
) {

    private val gson:Gson = Gson()

    private fun executeObjectPost(endpoint: String, body:JsonObject, params: Map<String, String>): ResponseObject<JsonObject> {
        val call = backApi.create(PostExecutor::class.java).makeRequest(endpoint, body, params)

        val response = call.execute()

        if (response.isSuccessful) {
            val obj = Gson().fromJson(response.body()?.string(), JsonObject::class.java)
            return ResponseObject(obj)
        }

        val error = Gson().fromJson(response.errorBody()?.string(), JsonObject::class.java)
        throw Exception(error.get("message").toString())
    }

    private fun executeArrayPost(endpoint: String, body:JsonObject, params: Map<String, String>): ResponseObject<JsonArray> {
        val call = backApi.create(PostExecutor::class.java).makeRequest(endpoint, body, params)

        val response = call.execute()
        if (response.isSuccessful) {
            return ResponseObject(response.body() as JsonArray)
        }

        val error = Gson().fromJson(response.errorBody()?.string(), JsonObject::class.java)
        throw Exception(error.get("message").asString)
    }


    fun executePostResponse(endpoint: String, body: JsonObject): JsonObjectWrapper {
        val response = executeObjectPost(endpoint = endpoint, body = body, params = mapOf())
        return JsonObjectWrapper(response.obj)
    }

    private interface PostExecutor {
        @HTTP(method = "POST", path = "{path}", hasBody = true)
        fun makeRequest(@Path("path") path:String, @Body body:JsonObject, @QueryMap params:Map<String, String>): Call<ResponseBody>
    }

}