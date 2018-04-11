package com.indra.vdiary.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.text.SimpleDateFormat
import java.util.*

/**
 * adding an extension function to view group
 */
fun ViewGroup.inflate(layoutId : Int, attachToRoot : Boolean = false) : View {
    // context == getContext() in java
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot);
}

fun Date.toReadable() : String {
    val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm")
    return sdf.format(this)
}