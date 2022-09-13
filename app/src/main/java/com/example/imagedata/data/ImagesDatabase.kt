package com.example.imagedata.data

import com.example.imagedata.model.ImageDataDB
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageDataDB::class], version = 2, exportSchema = false)
abstract class ImagesDatabase : RoomDatabase() {

    abstract fun userDao(): ImageDataDao

    companion object {
        @Volatile
        private var INSTANCE: ImagesDatabase? = null

        fun getDatabase(context: Context): ImagesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ImagesDatabase::class.java,
                    "img_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}