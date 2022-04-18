package com.example.hipointernapp.Domain
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserInfo(
    val cv: String,
    val email: String,
    val id: String,
    var name: String,
    val notes: String,
    val position: Position,
    val selected_periods: List<SelectedPeriod>
): Parcelable

@Parcelize
data class Position(
    val id: String,
    val name: String
) : Parcelable

@Parcelize
data class SelectedPeriod(
    val end_date: String,
    val id: String,
    val last_application_date: String,
    val location: String,
    val name: String,
    val start_date: String
): Parcelable

