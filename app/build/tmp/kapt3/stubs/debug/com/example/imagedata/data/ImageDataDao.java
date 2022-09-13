package com.example.imagedata.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/imagedata/data/ImageDataDao;", "", "addImages", "", "imageDataDB", "Lcom/example/imagedata/model/ImageDataDB;", "deleteAllImageData", "deleteImageData", "readAllImageData", "Landroidx/lifecycle/LiveData;", "", "updateImageData", "app_debug"})
public abstract interface ImageDataDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void addImages(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM img_table ORDER BY id ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.imagedata.model.ImageDataDB>> readAllImageData();
    
    @androidx.room.Update()
    public abstract void updateImageData(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB);
    
    @androidx.room.Delete()
    public abstract void deleteImageData(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB);
    
    @androidx.room.Query(value = "DELETE FROM img_table")
    public abstract void deleteAllImageData();
}