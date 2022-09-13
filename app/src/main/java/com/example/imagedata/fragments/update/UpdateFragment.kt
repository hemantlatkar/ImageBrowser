package com.example.imagedata.fragments.update

import com.example.imagedata.R
import com.example.imagedata.model.ImageDataDB
import com.example.imagedata.viewmodel.ImageViewModel
import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mImageViewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        mImageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        //getBitmapFromAsset("Images/"+args.currentImageData.imageStr,context)
        view.image_view.setImageBitmap(args.currentImageData.imageBitmap)
        view.et_comment.setText(args.currentImageData.imgComment)
        view.ratingbar.numStars = 5
        view.ratingbar.rating = args.currentImageData.imgRating

        view.update.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)
        return view
    }


    private fun updateItem() {
        val comment = et_comment.text.toString()
        val ratings = ratingbar.rating

        if (inputCheck(comment, ratings)) {
//            Create User Object
            val updatedImageDataDB = ImageDataDB(
                args.currentImageData.id,
                args.currentImageData.imageStr,
                comment,
                ratings
            )
//            Update User Object
            mImageViewModel.updateImageData(updatedImageDataDB)
            Toast.makeText(requireContext(), "Updated successfully", Toast.LENGTH_LONG).show()

//            Navigate back to list after updating data
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields..", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun inputCheck(comment: String, ratings: Float): Boolean {
        return !(TextUtils.isEmpty(comment) && ratings == 0f)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            val updatedImageDataDB =
                ImageDataDB(args.currentImageData.id, args.currentImageData.imageStr, "", 0f)
            mImageViewModel.updateImageData(updatedImageDataDB)
            Toast.makeText(
                requireContext(),
                "Deleted: ${args.currentImageData.imageStr.replace(".jpg", "")} data",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentImageData.imageStr.replace(".jpg", "")} data?")
        builder.setMessage(
            "Are you sure you want to delete ${
                args.currentImageData.imageStr.replace(
                    ".jpg",
                    ""
                )
            } data?"
        )
        builder.create().show()
    }

}