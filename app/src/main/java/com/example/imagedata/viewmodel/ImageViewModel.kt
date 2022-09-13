package com.example.imagedata.viewmodel

import com.example.imagedata.data.ImagesDatabase
import com.example.imagedata.data.repository.ImagesRepository
import com.example.imagedata.model.ImageDataDB
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<ImageDataDB>>
    private val repository: ImagesRepository

    init {
        val userDao = ImagesDatabase.getDatabase(application).userDao()
        repository = ImagesRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addImages(imageDataDB: ImageDataDB) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addImages(imageDataDB)
        }
    }

    fun updateImageData(imageDataDB: ImageDataDB) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateImageData(imageDataDB)
        }
    }

    fun deleteImageData(imageDataDB: ImageDataDB) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteImageData(imageDataDB)
        }
    }

    fun deleteAllImageData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllImageData()
        }
    }
}