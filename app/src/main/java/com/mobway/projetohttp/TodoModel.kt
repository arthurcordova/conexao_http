package com.mobway.projetohttp

data class TodoModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)