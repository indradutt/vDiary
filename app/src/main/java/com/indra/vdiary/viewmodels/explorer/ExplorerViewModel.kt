package com.indra.vdiary.viewmodels.explorer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.indra.vdiary.data.Content

/**
 * Created by indra.dutt on 3/20/18.
 */
class ExplorerViewModel : ViewModel() {
    val contentList = MutableLiveData<List<Content>> ()

}