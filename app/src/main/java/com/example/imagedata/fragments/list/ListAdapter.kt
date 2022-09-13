package com.example.imagedata.fragments.list

import com.example.imagedata.R
import com.example.imagedata.model.ImageModel
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var ImageModelList = emptyList<ImageModel>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return ImageModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ImageModelList[position]
        holder.itemView.img_view.setImageBitmap(currentItem.imageBitmap)
        if (!TextUtils.isEmpty(currentItem.imgComment)) {
            holder.itemView.tv_cmt.visibility = View.VISIBLE
            holder.itemView.tv_cmt.text = "Comment : " + currentItem.imgComment
        } else {
            holder.itemView.tv_cmt.visibility = View.GONE
        }
        if (!TextUtils.isEmpty(currentItem.imgRating.toString())) {
            holder.itemView.tv_rating.visibility = View.VISIBLE
            holder.itemView.tv_rating.text = "Rating : " + currentItem.imgRating.toString() + "/5"
        } else {
            holder.itemView.tv_rating.visibility = View.GONE
        }

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(ImageModel: List<ImageModel>) {
        this.ImageModelList = ImageModel
        notifyDataSetChanged()
    }
}