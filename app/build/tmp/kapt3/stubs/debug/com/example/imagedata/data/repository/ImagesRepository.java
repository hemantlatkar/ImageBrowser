package com.example.imagedata.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/imagedata/data/repository/ImagesRepository;", "", "imageDataDao", "Lcom/example/imagedata/data/ImageDataDao;", "(Lcom/example/imagedata/data/ImageDataDao;)V", "readAllData", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/imagedata/model/ImageDataDB;", "getReadAllData", "()Landroidx/lifecycle/LiveData;", "addImages", "", "imageDataDB", "(Lcom/example/imagedata/model/ImageDataDB;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllImageData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteImageData", "updateImageData", "app_debug"})
public final class ImagesRepository {
    private final com.example.imagedata.data.ImageDataDao imageDataDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.imagedata.model.ImageDataDB>> readAllData = null;
    
    public ImagesRepository(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.data.ImageDataDao imageDataDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.imagedata.model.ImageDataDB>> getReadAllData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addImages(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateImageData(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteImageData(@org.jetbrains.annotations.NotNull()
    com.example.imagedata.model.ImageDataDB imageDataDB, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllImageData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}