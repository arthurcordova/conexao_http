package com.mobway.projetohttp

import com.google.gson.annotations.SerializedName

data class UserPhotoModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)