package com.indra.vdiary.data

import java.util.*

/**
 * Created by indra.dutt on 3/20/18.
 */
open abstract class Message (val title: String,
                             val createdTime: Date,
                             val lastModifiedTime: Date,
                             val contentPath: String,
                             val previewPath: String) {

    open abstract fun getContent() : Any
}

class TextMessage(val text: String,
                  title: String,
                  createdTime: Date,
                  lastModifiedTime: Date,
                  contentPath: String,
                  previewPath: String) : Message(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): Text {
        TODO("not implemented")
    }
}

class AudioMessage(val audio: Audio,
                   title: String,
                   createdTime: Date,
                   lastModifiedTime: Date,
                   contentPath: String,
                   previewPath: String) : Message(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): Audio {
        TODO("not implemented")
    }
}

class VideoMessage(val video: Video,
                   title: String,
                   createdTime: Date,
                   lastModifiedTime: Date,
                   contentPath: String,
                   previewPath: String) : Message(title, createdTime, lastModifiedTime, contentPath, previewPath) {

    override fun getContent(): Video {
        TODO("not implemented")
    }
}