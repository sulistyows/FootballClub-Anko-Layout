package com.sulistyo.test

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(val name: String, val image: Int, val description: String) : Parcelable