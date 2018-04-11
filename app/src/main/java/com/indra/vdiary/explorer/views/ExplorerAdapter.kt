package com.indra.vdiary.explorer.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.indra.vdiary.BR
import com.indra.vdiary.R
import com.indra.vdiary.common.data.Content

/**
 * Created by indra.dutt on 3/22/18.
 */
class ExplorerAdapter(private val list : List<Content>, private val listener : (Content) -> Unit)
    : RecyclerView.Adapter<ExplorerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
                layoutInflator, R.layout.item_explorer, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position], listener)

    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(msg: Content, listener: (Content) -> Unit) = with(binding.root) {
            setOnClickListener { listener(msg) }
            binding.setVariable(BR.content, msg)
            binding.executePendingBindings()
        }
    }
}

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}

object VideoBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:videoUrl")
    fun setVideoUrl(videoView: VideoView, url: String) {
        //videoView.setMediaController(MediaController(videoView.context))
        val uri = Uri.parse(url)
        videoView.setVideoURI(uri)
        videoView.seekTo(500)
    }
}