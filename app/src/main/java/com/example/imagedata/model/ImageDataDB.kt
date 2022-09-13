package com.example.imagedata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "img_table", indices = [Index(value = ["imgStr"], unique = true)])
data class ImageDataDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val imgStr: String,
    val imgComment: String,
    val imgRating: Float
) : Parcelable