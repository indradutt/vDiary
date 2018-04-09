package com.indra.vdiary.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * adding an extension function to view group
 */
fun ViewGroup.inflate(layoutId : Int, attachToRoot : Boolean = false) : View {
    // context == getContext() in java
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot);
}