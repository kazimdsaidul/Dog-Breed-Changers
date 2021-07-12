package com.saidul.dogbreed.ui.homePage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.saidul.dogbreed.R
import com.saidul.dogbreed.ui.homePage.viewmodel.ImageModel
import kotlinx.android.synthetic.main.item_dog_image.view.*


class ImagesAdapter(val context: Context) :
    PagingDataAdapter<ImageModel, RecyclerView.ViewHolder>(
        ModelComparator
    ) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieModel: ImageModel = getItem(position)!!

        movieModel.let {
            when (movieModel) {
                is ImageModel.ImageItem -> {

                    val options: RequestOptions = RequestOptions()
                        .centerCrop()
                        .placeholder(R.drawable.progress_animation)
                        .error(R.drawable.progress_animation)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH)
                        .dontAnimate()
                        .dontTransform()


                    Glide.with(context).load(movieModel.dataItem.url).apply(options)
                        .into(holder.itemView.imageView)


                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ImageModel.ImageItem -> R.layout.movie_item
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_dog_image,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    companion object {
        private val ModelComparator = object : DiffUtil.ItemCallback<ImageModel>() {
            override fun areItemsTheSame(
                oldItem: ImageModel,
                newItem: ImageModel
            ): Boolean {
                return (oldItem is ImageModel.ImageItem && newItem is ImageModel.ImageItem &&
                        oldItem.dataItem.id == newItem.dataItem.id)
            }

            override fun areContentsTheSame(
                oldItem: ImageModel,
                newItem: ImageModel
            ): Boolean =
                oldItem == newItem
        }
    }


}