package com.sefio.suay.data.remote

import com.sefio.suay.data.remote.helpers.ProductApi
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(
    private val productApi: ProductApi
) {


}