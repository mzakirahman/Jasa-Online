package com.example.jasaonline.models

data class LoginResponse (
    val message: String,
    val error: Boolean,
    val data: User
)