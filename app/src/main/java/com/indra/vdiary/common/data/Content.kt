package com.indra.vdiary.common.data

import android.databinding.BaseObservable
import android.view.View
import java.util.*

/**
 * Created by indra.dutt on 3/20/18.
 */
open abstract class Content(val title: String,
                            val createdTime: Date,
                            val lastModifiedTime: Date,
                            var contentPath: String,
                            var previewPath: String) : BaseObservable() {

    open abstract fun getContent() : Any

    fun isPreviewAvailable() : Int {
        return if (previewPath?.isNotEmpty()) View.VISIBLE else View.GONE
    }

    fun isContentAvailable() : Int {
        return if (contentPath?.isNotEmpty()) View.VISIBLE else View.GONE
    }
}

class TextContent(val summary: String,
                  title: String,
                  createdTime: Date,
                  lastModifiedTime: Date,
                  contentPath: String,
                  previewPath: String) : Content(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): String {
        return summary
    }

}

class AudioContent(title: String,
                   createdTime: Date,
                   lastModifiedTime: Date,
                   contentPath: String,
                   previewPath: String) : Content(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): Any {
        return ""
    }
}

class VideoContent(title: String,
                   createdTime: Date,
                   lastModifiedTime: Date,
                   contentPath: String,
                   previewPath: String) : Content(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): Any {
        return ""
    }
}