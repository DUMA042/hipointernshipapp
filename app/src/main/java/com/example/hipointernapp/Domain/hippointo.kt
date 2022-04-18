package com.example.hipointernapp.Domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class hippointo(val id:Double,
                     val name:String,
                     val positions:List<allPosition>,
                     val start_date:String,
                     val end_date:String,
                     val last_application_date:String,
                     val location:String
) : Parcelable

@Parcelize
data class  allPosition(val id:Double,val name:String) : Parcelable