package com.example.bugclassification.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PredictData(
    val predictedClass: String?,
    val confidence: Int?,
) : Parcelable
