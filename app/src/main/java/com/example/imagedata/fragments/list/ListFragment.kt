package com.example.imagedata.fragments.list

import com.example.imagedata.R
import com.example.imagedata.model.ImageDataDB
import com.example.imagedata.model.ImageModel
import com.example.imagedata.viewmodel.ImageViewModel
import android.app.AlertDialog
import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*
import java.io.IOException
import java.util.*

class ListFragment : Fragment() {

    private lateinit var mImageViewModel: ImageViewModel
    private var bitmapList = ArrayList<Bitmap>()
    private var localListDB = ArrayList<ImageModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mImageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)
        context?.let { getImageFromAsset(it) }
        mImageViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            if (user.size == bitmapList.size) {
                for (i in 0 until user.size) {
                    val imgModel = ImageModel(
                        user[i].id,
                        user[i].imgStr,
                        bitmapList[i],
                        user[i].imgComment,
                        user[i].imgRating
                    )
                    localListDB.add(imgModel)
                }
            } else {
                localListDB.clear()
            }
            adapter.setData(localListDB)
        })
        setHasOptionsMenu(true)
        return view
    }

    @Throws(IOException::class)
    private fun getImageFromAsset(context: Context) {
        try {
            val assetManager: AssetManager = context.getAssets()
            val files = assetManager.list("Images")
            bitmapList.clear()
            for (i in 0 until files?.asList()!!.size) {
                val istr = assetManager.open("Images/" + files.get(i).toString())
                val bitmapOne = getBitmapFromAsset("Images/" + files.get(i).toString(), context)
                bitmapOne?.let { bitmapList.add(it) }
                istr.close()
            }

            mImageViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
                if (user.size == 0) {
                    for (i in 0 until files?.asList()!!.size) {
                        val imageDataDB = ImageDataDB(0, files.get(i).toString(), "", 0f)
                        mImageViewModel.addImages(imageDataDB)
                    }
                }
            })
        } catch (e: Exception) {
        }
    }

    @Throws(IOException::class)
    private fun getBitmapFromAsset(strName: String, context: Context): Bitmap? {
        val assetManager: AssetManager = context.getAssets()
        val istr = assetManager.open(strName)
        val bitmap = BitmapFactory.decodeStream(istr)
        istr.close()
        Log.d("BITMAP_List_COUNT", "" + bitmapList.size)
        return bitmap
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            deleteAllRecord()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllRecord() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mImageViewModel.deleteAllImageData()
            Toast.makeText(requireContext(), "Ratings & comment cleared", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Clear All?")
        builder.setMessage("Are you sure you want to clear all image rating/comments?")
        builder.create().show()
    }

}