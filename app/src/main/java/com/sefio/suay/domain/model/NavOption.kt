package com.sefio.suay.domain.model

data class NavOption (
    val title:String,
    val onClick: () -> Unit
        )