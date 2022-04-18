package com.example.hipointernapp.Domain

data class UserInfoInput(
    val cv: String?,
    val email: String?,
    val name: String?,
    val notes: String?,
    val position: Int?,
    val selected_periods: List<Int?>
)