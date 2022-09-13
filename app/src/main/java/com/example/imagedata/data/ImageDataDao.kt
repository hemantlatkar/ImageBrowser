package com.example.imagedata.data

import com.example.imagedata.model.ImageDataDB
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addImages(imageDataDB: ImageDataDB)

    @Query("SELECT * FROM img_table ORDER BY id ASC")
    fun readAllImageData(): LiveData<List<ImageDataDB>>

    @Update
    fun updateImageData(imageDataDB: ImageDataDB)

    @Delete
    fun deleteImageData(imageDataDB: ImageDataDB)

    @Query("DELETE FROM img_table")
    fun deleteAllImageData()
}