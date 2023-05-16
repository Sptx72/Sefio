package com.sefio.suay.data.local

import com.sefio.suay.data.local.db.SefioDatabase
import com.sefio.suay.domain.model.Response
import com.sefio.suay.helpers.AppTextUtils
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val sefioDatabase: SefioDatabase,
) {

    fun isLogged(): Response<Boolean> {
        return try {
            Response.Success(!AppTextUtils.isEmpty(sefioDatabase.getAuthDAO().fetchNickName()))
        } catch (e:Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    fun saveIdentification(id: String) {
        sefioDatabase.getAuthDAO().saveIdentification(id);
    }

}