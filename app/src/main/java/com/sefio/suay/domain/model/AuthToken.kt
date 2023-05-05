package com.sefio.suay.domain.model

data class AuthToken(
    val nickname:String,
    val token:String,
    val user:User?
)
