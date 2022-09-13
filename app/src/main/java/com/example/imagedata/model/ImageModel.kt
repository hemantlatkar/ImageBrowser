package com.example.imagedata.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageModel(
    val id: Int,
    val imageStr: String,
    val imageBitmap: Bitmap,
    val imgComment: String,
    val imgRating: Float
) : Parcelable