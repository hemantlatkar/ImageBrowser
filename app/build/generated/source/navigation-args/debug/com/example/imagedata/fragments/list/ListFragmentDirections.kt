package com.example.imagedata.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.imagedata.R
import com.example.imagedata.model.ImageModel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToUpdateFragment(
    val currentImageData: ImageModel
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listFragment_to_updateFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
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
  }

  companion object {
    fun actionListFragmentToUpdateFragment(currentImageData: ImageModel): NavDirections =
        ActionListFragmentToUpdateFragment(currentImageData)
  }
}
