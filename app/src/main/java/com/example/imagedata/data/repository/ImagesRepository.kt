package com.example.imagedata.data.repository

import com.example.imagedata.data.ImageDataDao
import com.example.imagedata.model.ImageDataDB
import androidx.lifecycle.LiveData

class ImagesRepository(private val imageDataDao: ImageDataDao) {

    val readAllData: LiveData<List<ImageDataDB>> = imageDataDao.readAllImageData()

    suspend fun addImages(imageDataDB: ImageDataDB) {
        imageDataDao.addImages(imageDataDB)
    }

    suspend fun updateImageData(imageDataDB: ImageDataDB) {
        imageDataDao.updateImageData(imageDataDB)
    }

    suspend fun deleteImageData(imageDataDB: ImageDataDB) {
        imageDataDao.deleteImageData(imageDataDB)
    }

    suspend fun deleteAllImageData() {
        imageDataDao.deleteAllImageData()
    }
}