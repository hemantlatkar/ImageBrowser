package com.example.imagedata.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.imagedata.model.ImageModel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdateFragmentArgs(
  val currentImageData: ImageModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(ImageModel::class.java)) {
      result.putParcelable("currentImageData", this.currentImageData as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(ImageModel::class.java)) {
      result.putSerializable("currentImageData", this.currentImageData as Serializable)
    } else {
      throw UnsupportedOperationException(ImageModel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdateFragmentArgs {
      bundle.setClassLoader(UpdateFragmentArgs::class.java.classLoader)
      val __currentImageData : ImageModel?
      if (bundle.containsKey("currentImageData")) {
        if (Parcelable::class.java.isAssignableFrom(ImageModel::class.java) ||
            Serializable::class.java.isAssignableFrom(ImageModel::class.java)) {
          __currentImageData = bundle.get("currentImageData") as ImageModel?
        } else {
          throw UnsupportedOperationException(ImageModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentImageData == null) {
          throw IllegalArgumentException("Argument \"currentImageData\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentImageData\" is missing and does not have an android:defaultValue")
      }
      return UpdateFragmentArgs(__currentImageData)
    }
  }
}
