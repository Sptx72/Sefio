package com.sefio.suay.data.remote.helpers

import com.sefio.suay.data.remote.back.BackApi
import javax.inject.Inject

class ProductApi @Inject constructor(
    private val backApi: BackApi,
    private val productMapper: ProductMapper,
    private val apiRequestExecutor: ApiRequestExecutor
){


}